/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.doundo.CommandManager;
import model.doundo.setCell;
import model.filters.Filter;
import model.filters.FilterFactory;
import model.operations.AbstractOperationFactory;
import model.operations.Operation;
import model.viewmode.IViewModeStrategy;
import presenter.IMainPresenter;

/**
 *
 * @author Luis
 */
public class Model extends AbstractTableModel implements IModel {
    
    public final static int TABLE_ROWS = 10;
    public final static int TABLE_COLUMNS = 8;
    
    private CommandManager cmdManager;
    private IMainPresenter presenter;
    private Cell[][] sheet;
    private int selectedRow;
    private int selectedColumn;
    private List<String> selectedFilters;
    
    public Model(IMainPresenter presenter) {
        cmdManager = new CommandManager(this);
        this.presenter = presenter;
        this.selectedRow = -1;
        this.selectedColumn = -1;
        this.selectedFilters = new ArrayList<>();
        initSheet();
    }
    
    private void initSheet(){
        sheet = new Cell[TABLE_ROWS][TABLE_COLUMNS];
        
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
            if(selectedFilters.get(i).equals(type)){
                return i;
            }
        }
        
        return -1;
    }

    private String getCellId(int row, int column){
        return getColumnName(column) + (++row);
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
        Cell cell = sheet[rowIndex][columnIndex];
        
        if(cell instanceof Filter){
            return ((Filter) cell).getFilteredValue();
        }
        
        return cell.getViewModeValue();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Cell currentCell = sheet[rowIndex][columnIndex];

        Cell oldCell = new Cell(currentCell);
        
        try{
            
            if(currentCell instanceof Filter){
                ((Filter) currentCell).setValue((String) value);
            }else{
                currentCell.setValue((String) value);
            }
            
        }catch(NullPointerException ex){
            throw ex;
        }
        
        AbstractOperationFactory factory = AbstractOperationFactory
                .getOperationFactory((String) value);
        
        Operation operation = null;
        
        if(factory != null){
            operation = factory.getOperation(currentCell, this);
        }
                
        currentCell.setOperation(operation);
        
        cmdManager.apply(new setCell(new Cell(currentCell), oldCell));
        
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
    public Cell findCellById(String id) {
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
    public List<Cell> getRangeOfCells(int row1, int column1, int row2, int column2) {
        List<Cell> involvedCells = new ArrayList<>();
        
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                involvedCells.add(sheet[i][j]);
            }
        }
        
        return involvedCells;
    }
    
    @Override
    public List<Cell> getRanfeOfCells(String[] cellIds) {
        List<Cell> involvedCells = new ArrayList<>();
        
        for (String cellId : cellIds) {
            Cell c = findCellById(cellId);
            involvedCells.add(c);
        }
        
        return involvedCells;
    }

    @Override
    public void setCell(Cell cell) {
        sheet[cell.getRow()][cell.getColumn()] = cell;
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
    public Cell getSelectedCell() {
        return sheet[selectedRow][selectedColumn];
    }

    @Override
    public void setSelectedCell(Cell cell) {
        sheet[selectedRow][selectedColumn] = cell;
    }
    
    @Override
    public void addFilter(String type) {
        if(selectedFilters.contains(type)){
            System.out.println("Already exists! " + type);
            return;
        }
        
        System.out.println("Added: " + type);
        selectedFilters.add(type);
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
    public Cell getDecoratedCell(Cell originalCell, double x) {
        
        Cell cellToDecorate = new Cell(originalCell);
        
        for (String type : selectedFilters) {
            Cell filter = (Cell) FilterFactory.getFilter(type, x, cellToDecorate);
            cellToDecorate = filter;
        }
        
        if(cellToDecorate instanceof Filter){
            ((Filter) cellToDecorate).setOldCell(originalCell);
        }
        
        return cellToDecorate;
    }

    @Override
    public void clearSelectedFilters() {
        selectedFilters.clear();
    }

    @Override
    public Cell getCellToDecorate() {
        Cell temp = getSelectedCell();
        
        while(temp instanceof Filter){
            temp = ((Filter) temp).getNextCell();
        }
        
        return temp;
    }

    
    
}
