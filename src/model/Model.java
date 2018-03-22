/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.command.CommandManager;
import model.command.Macro;
import model.command.setCell;
import model.filters.EqualFilterDecorator;
import model.filters.Filter;
import model.filters.InferiorFilterDecorator;
import model.filters.SuperiorFilterDecotator;
import model.viewmode.IViewModeStrategy;
import utils.ViewModeUtils;

/**
 *
 * @author Luis
 */
public class Model implements IModel, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public transient final static int TABLE_ROWS = 10;
    public transient final static int TABLE_COLUMNS = 8;
    
    private transient CommandManager cmdManager;
    private transient Macro macro;
    private transient AbsTableModel tableModel;
    private Filter[][] sheet;
    private int selectedRow;
    private int selectedColumn;
    private ArrayList<Filter> selectedFilters;
    private transient String viewMode;
    
    public Model() {
        this.cmdManager = new CommandManager(this);
        this.macro = new Macro();
        this.tableModel = new AbsTableModel(this);
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
        return tableModel.getCellId(row, column);
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
    public void updateCells() {
        tableModel.updateCells();
    }
    
    @Override
    public void updateSelectedCell() {
        tableModel.updateSelectedCell(selectedRow, selectedColumn);
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
        
        if(row1 > TABLE_ROWS 
                || row2 > TABLE_ROWS 
                || column1 > TABLE_COLUMNS
                || column2 > TABLE_COLUMNS){
            return involvedCells;
        }
        
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

    @Override
    public CommandManager getCmdManager() {
        return cmdManager;
    }

    @Override
    public Macro getMacro() {
        return macro;
    }

    @Override
    public Filter[][] getSheet() {
        return sheet;
    }

    @Override
    public AbsTableModel getTableModel() {
        return tableModel;
    }

    @Override
    public void setVariablesAfterOpeningSavedSheet() {
        this.cmdManager = new CommandManager(this);
        this.macro = new Macro();
        this.tableModel = new AbsTableModel(this);
        this.viewMode = ViewModeUtils.getDefaultViewMode();
        this.setCellsViewMode(ViewModeUtils.getDefaultViewModeStrategy());
    }
    
}
