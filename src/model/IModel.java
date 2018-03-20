/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.filters.Filter;
import model.viewmode.IViewModeStrategy;

/**
 *
 * @author Luis
 */
public interface IModel {
    
    void updateCells();
    
    void updateSelectedCell();  
    
    Filter findCellById(String id);
    
    List<Filter> getRangeOfCells(int row1, int column1, int row2, int column2);
    
    List<Filter> getRanfeOfCells(String []cellIds);
    
    void setCell(Filter cell);
    
    void undo();
    
    void redo();
    
    void setCellsViewMode(IViewModeStrategy viewMode);
    
    void setSelectedCellRowColumn(int selectedRow, int selectedColumn);
    
    Filter getSelectedCell();
    
    void setSelectedCell(Filter cell);
    
    void addFilter(String type);
    
    void removeFilter(String type);
    
    Filter getDecoratedCell(Filter originalCell, double x);
    
    void clearSelectedFilters();
    
    Filter getCellToDecorate();
    
}
