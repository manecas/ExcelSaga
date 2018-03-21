/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.io.File;

/**
 *
 * @author Luis
 */
public interface IMainPresenter {
    
    void setTableModel();
    
    void onFilterClicked(int selectedRow, int selectedColumn);
    void onFilterPressed();
    void onFilterReleased();
    
    void onViewModeClicked();
    
    void onExitClicked();
    void onExitPressed();
    void onExitReleased();
    
    void onRedoClicked();
    void onRedoPressed();
    void onRedoReleased();
    
    void onUndoClicked();
    void onUndoPressed();
    void onUndoReleased();
    
    void onSheetClicked();
    
    void onOptionsClicked();
    
    void onHeaderPressed(int x, int y);
    void onHeaderDragged(int x, int y);
 
    void onPlayMacroClicked();
    void onPlayMacroPressed();
    void onPlayMacroReleased();
    
    void onRecordMacroClicked();
    
    void onSaveClicked();
    void onSavePressed();
    void onSaveReleased();
    void onSaveEntered();
    void onSaveExited();
    
    void saveSheet(File file);
    
    void onOpenClicked();
    void onOpenPressed();
    void onOpenReleased();
    void onOpenEntered();
    void onOpenExited();
    
    void onExportEntered();
    void onExportExited();
    
    void onExportTextEntered();
    void onExportTextExited();
    
    void onExportCsvEntered();
    void onExportCsvExited();
    
    void onExportHtmlEntered();
    void onExportHtmlExited();
    
    void onImportEntered();
    void onImportExited();
    
    void onImportCsvEntered();
    void onImportCsvExited();
    
}
