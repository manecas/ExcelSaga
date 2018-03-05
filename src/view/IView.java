/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.TableModel;

/**
 *
 * @author Luis
 */
public interface IView {
    
    void setTableModel(TableModel tableModel);
    
    void setViewMode(String viewMode);
    void setViewModeColor();
    void resetViewModeColor();
    
    void exitSystem();
    void setExitColor();
    void resetExitColor();
    
    void setRedoColor();
    void resetRedoColor();
            
    void setUndoColor();
    void resetUndoColor();
    
    void ShowSheetPanel();
    void hideSheetPanel();
    void setSheetColor();
    void resetSheetColor();
    
    void ShowOptionsPanel();
    void hideOptionsPanel();
    void setOptionsColor();
    void resetOptionsColor();
    
    void setWindowPressedCoordinates(int x, int y);
    void setWindowDraggedCoordinates(int x, int y);
    void setWindowLocation(int x, int y);
    int getXX();
    int getYY();
    int getX();
    int getY();
}
