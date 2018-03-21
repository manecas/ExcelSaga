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
public interface IMainView {
    
    void setTableModel(TableModel tableModel);
    
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
    
    void showFilterWindow(IFilterView filterView);
    void setFilterColor();
    void resetFilterColor();
    
    void setRecordMacroColor();
    void resetRecordMacroColor();
    
    void setPlayMacroColor();
    void resetPlayMacroColor();
    
    void setWindowPressedCoordinates(int x, int y);
    void setWindowDraggedCoordinates(int x, int y);
    void setWindowLocation(int x, int y);
    int getXX();
    int getYY();
    int getX();
    int getY();
    
    void showMessageDialog(String message);
    
    void showSaveFileChooser();
    
    void showOpenFileChooser();
    
    void setSaveColor();
    void resetSaveColor();
    
    void setOpenColor();
    void resetOpenColor();
    
    void setExportPanelSize();
    void resetExportPanelSize();
    
    void setExportColor();
    void resetExportColor();
    
    void setExportTextColor();
    void resetExportTextColor();
    
    void setExportCsvColor();
    void resetExportCsvColor();
    
    void setExportHtmlColor();
    void resetExportHtmlColor();
    
    void setImportPanelSize();
    void resetImportPanelSize();
    
    void setImportColor();
    void resetImportColor();
    
    void setImportCsvColor();
    void resetImportCsvColor();
}
