/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.viewmode.IViewModeStrategy;

/**
 *
 * @author Luis
 */
public interface IModel {
    
    void updateCells();
    
    Cell findCellById(String id);
    
    List<Cell> getRangeOfCells(int row1, int column1, int row2, int column2);
    
    List<Cell> getRanfeOfCells(String []cellIds);
    
    void setCell(Cell cell);
    
    void undo();
    
    void redo();
    
    void setCellsViewMode(IViewModeStrategy viewMode);
    
    void setSelectedCellRowColumn(int selectedRow, int selectedColumn);
    
    Cell getSelectedCell();
    
}
