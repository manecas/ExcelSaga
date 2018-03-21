/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.command.CommandManager;
import model.command.Macro;
import model.command.setCell;
import model.filters.EqualFilterDecorator;
import model.filters.Filter;
import model.filters.InferiorFilterDecorator;
import model.filters.SuperiorFilterDecotator;
import model.operations.AbstractOperationFactory;
import model.operations.Operation;
import model.viewmode.IViewModeStrategy;
import presenter.IMainPresenter;
import utils.ViewModeUtils;

/**
 *
 * @author Luis
 */
public class Model extends AbstractTableModel implements IModel, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public transient final static int TABLE_ROWS = 10;
    public transient final static int TABLE_COLUMNS = 8;
    
    private CommandManager cmdManager;
    private Macro macro;
    private transient IMainPresenter presenter; //transient
    private Filter[][] sheet;
    private int selectedRow;
    private int selectedColumn;
    private ArrayList<Filter> selectedFilters;
    private String viewMode;
    
    public Model(IMainPresenter presenter) {
        this.cmdManager = new CommandManager(this);
        this.macro = new Macro();
        this.presenter = presenter;
        this.selectedRow = -1;
        this.selectedColumn = -1;
        this.selectedFilters = new ArrayList<>();
        this.viewMode = ViewModeUtils.getDefaultViewMode();
        initSheet();
    }
    
    private void initSheet(){
        sheet = new Filter[TABLE_ROWS][TABLE_COLUMNS];
        
        for (int i = 0; i < TABLE_ROWS; i++) {
            for (int j = 0; j < TABLE_COLUMNS; j++) {
                String cellId = getCellId(i, j);
                sheet[i][j] = new Cell(cellId, i, j);
                System.out.print(cellId + " ");
            }
            System.out.println("");
        }
    }
    
    private int findFilterIndex(String type){
        for (int i = 0; i < selectedFilters.size(); i++) {
            if(selectedFilters.get(i).getType().equals(type)){
                return i;
            }
        }
        
        return -1;
    }

    private String getCellId(int row, int column){
        return getColumnName(column) + (++row);
    }
    
    @Override
    public String getViewMode() {
        return viewMode;
    }

    @Override
    public void setViewMode(String viewMode) {
        this.viewMode = viewMode;
    }

    @Override
    public boolean isRecordingMacro() {
        return macro.isRecordingMacro();
    }

    @Override
    public void setRecordingMacro(boolean recordingMacro) {
        macro.setRecordingMacro(recordingMacro);
    }
    
    @Override
    public void playMacro() {
        cmdManager.apply(macro.getCommands());
    }

    @Override
    public void clearMacro() {
        macro.clearCommands();
    }
    
    @Override
    public int getRowCount() {
        return TABLE_ROWS;                                                                  
    }

    @Override
    public int getColumnCount() {
        return TABLE_COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filter cell = sheet[rowIndex][columnIndex];
        
        if(!(cell instanceof Cell)){
            return cell.getFilteredValue(); 
        }
        
        return cell.getViewModeValue();
    }
 
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Filter currentCell = sheet[rowIndex][columnIndex];

        if(currentCell.getValue().equals((String) value)){
            return;
        }
        
        Filter oldCell = currentCell.getCopy();
         
        try{
            currentCell.setValue((String) value);
        }catch(NullPointerException ex){
            throw ex;
        }
        
        AbstractOperationFactory factory = AbstractOperationFactory
                .getOperationFactory((String) value);
        
        Operation operation = null;
        
        if(factory != null){
            operation = factory.getOperation(currentCell, this);
        }

        if(operation != null){
            currentCell.setOperation(operation);
            currentCell.getOperation().findInvolvedCells();
        }
        
        if(macro.isRecordingMacro()){
            macro.addCommand(new setCell(currentCell.getCopy(), oldCell.getCopy()));
        }
        
        cmdManager.apply(new setCell(currentCell.getCopy(), oldCell.getCopy()));
        
        currentCell.getOriginalCell().updateListeners();
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void updateCells() {
        fireTableDataChanged();
    }
    
    @Override
    public void updateSelectedCell() {
        fireTableCellUpdated(selectedRow, selectedColumn);
    }

    @Override
    public Filter findCellById(String id) {
        for (int i = 0; i < TABLE_ROWS; i++) {
            for (int j = 0; j < TABLE_COLUMNS; j++) {
                if(sheet[i][j].getId().equals(id)){
                    return sheet[i][j];
                }
            }
        }
        
        return null;
    }
    
    @Override
    public ArrayList<Filter> getRangeOfCells(int row1, int column1, int row2, int column2) {
        ArrayList<Filter> involvedCells = new ArrayList<>();
        
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                involvedCells.add(sheet[i][j]);
            }
        }
        
        return involvedCells;
    }
    
    @Override
    public ArrayList<Filter> getRanfeOfCells(String[] cellIds) {
        ArrayList<Filter> involvedCells = new ArrayList<>();
        
        for (String cellId : cellIds) {
            Filter c = findCellById(cellId);
            involvedCells.add(c);
        }
        
        return involvedCells;
    }

    @Override
    public void setCell(Filter newCell) {
        try{
            sheet[newCell.getRow()][newCell.getColumn()] = newCell;
        }catch(ArrayStoreException ex){
            throw ex;
        }
    }
    
    @Override
    public void undo() {
        cmdManager.undo();
    }

    @Override
    public void redo() {
        cmdManager.redo();
    }
    
    @Override
    public void setCellsViewMode(IViewModeStrategy viewMode) {
        for (int i = 0; i < TABLE_ROWS; i++) {
            for (int j = 0; j < TABLE_COLUMNS; j++) {
                sheet[i][j].setViewMode(viewMode);
            }
        }
    }

    @Override
    public void setSelectedCellRowColumn(int selectedRow, int selectedColumn) {
        this.selectedRow = selectedRow;
        this.selectedColumn = selectedColumn;
    }

    @Override
    public Filter getSelectedCell() {
        return sheet[selectedRow][selectedColumn];
    }

    @Override
    public void setSelectedCell(Filter newCell) {
        //Filters
        try{
            
            Filter oldCell = 
                    sheet[selectedRow][selectedColumn].getCopy();
            sheet[selectedRow][selectedColumn] = newCell.getCopy();
            
            if(macro.isRecordingMacro()){
                macro.addCommand(new setCell(newCell.getCopy(), oldCell.getCopy()));
            }
            
            cmdManager.apply(new setCell(newCell.getCopy(), oldCell.getCopy()));
            
        }catch(ArrayStoreException ex){
            throw ex;
        }
    }
    
    @Override
    public void addFilter(Filter filter) {
        if(selectedFilters.contains(filter)){
            System.out.println("Already exists! " + filter.getType());
            return;
        }
        
        System.out.println("Added: " + filter.getType());
        selectedFilters.add(filter);
    }

    @Override
    public void removeFilter(String type) {
        int filterIndex = findFilterIndex(type);
        
        if(filterIndex == -1){
            System.out.println("Index = : " + filterIndex);
            return;
        }

        System.out.println("Removed: " + type);
        selectedFilters.remove(filterIndex);
    }

    @Override
    public Filter getDecoratedCell(Filter originalCell, double x) {
        
        Filter cellToDecorate = originalCell;
        
        for (Filter f : selectedFilters) {
            f.setNextCell(cellToDecorate);
            
            if(f instanceof SuperiorFilterDecotator){
                ((SuperiorFilterDecotator) f).setX(x);
            }else if(f instanceof EqualFilterDecorator){
                ((EqualFilterDecorator) f).setX(x);
            }else if(f instanceof InferiorFilterDecorator){
                ((InferiorFilterDecorator) f).setX(x);
            }
            
            cellToDecorate = f;
        }
        
        return cellToDecorate;
    }

    @Override
    public void clearSelectedFilters() {
        selectedFilters.clear();
    }

    @Override
    public Filter getCellToDecorate() {
        return getSelectedCell().getOriginalCell();
    }

    @Override
    public ArrayList<Filter> getSelectedCellFilters() {
        
        Filter currentCell = sheet[selectedRow][selectedColumn];
        
        while(!(currentCell instanceof Cell)){
            selectedFilters.add(currentCell);
            currentCell = currentCell.getNextCell();
        }
        
        return new ArrayList<>(selectedFilters);
    }

}
