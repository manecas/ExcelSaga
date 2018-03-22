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
import model.filters.Filter;
import model.viewmode.IViewModeStrategy;

/**
 *
 * @author Luis
 */
public interface IModel extends Serializable {
    
    String getViewMode();
    
    void setViewMode(String viewMode);
    
    boolean isRecordingMacro();
        
    void setRecordingMacro(boolean recordingMacro);
    
    void playMacro();
    
    void clearMacro();
    
    void updateCells();
    
    void updateSelectedCell();  
    
    Filter findCellById(String id);
    
    ArrayList<Filter> getRangeOfCells(int row1, int column1, int row2, int column2);
    
    ArrayList<Filter> getRanfeOfCells(String []cellIds);
    
    void setCell(Filter newCell);
    
    void undo();
    
    void redo();
    
    void setCellsViewMode(IViewModeStrategy viewMode);
    
    void setSelectedCellRowColumn(int selectedRow, int selectedColumn);
    
    Filter getSelectedCell();
    
    void setSelectedCell(Filter newCell);
    
    void addFilter(Filter filter);
    
    void removeFilter(String type);
    
    Filter getDecoratedCell(Filter originalCell, double x);
    
    void clearSelectedFilters();
    
    Filter getCellToDecorate();
    
    ArrayList<Filter> getSelectedCellFilters();
    
    public CommandManager getCmdManager();

    public Macro getMacro();

    public Filter[][] getSheet();
    
    public AbsTableModel getTableModel();
    
    public void setVariablesAfterOpeningSavedSheet();
    
}
