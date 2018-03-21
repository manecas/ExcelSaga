/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import javax.swing.table.TableModel;
import model.Model;
import model.IModel;
import model.viewmode.FunctionalViewMode;
import model.viewmode.NormalViewMode;
import utils.ViewModeUtils;
import view.FilterView;
import view.IFilterView;
import view.IMainView;

//PRESENTER
public class MainPresenter implements IMainPresenter {

    private IMainView mainView;
    private IModel model;
    
    public MainPresenter(IMainView view) {
        this.mainView = view;
        this.model = new Model(this);
    }
    
    @Override
    public void setTableModel() {
        try{
            mainView.setTableModel((TableModel) model);
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onFilterClicked(int selectedRow, int selectedColumn) {
        try{
            if(selectedRow == -1 || selectedColumn == -1){
                mainView.showMessageDialog("You need to select a cell first!");
                return;
            }

            model.setSelectedCellRowColumn(selectedRow, selectedColumn);
            IFilterView filterView = new FilterView();
            filterView.setPresenter(new FilterPresenter(filterView, model));
            mainView.showFilterWindow(filterView);   
        }catch(NullPointerException ex){
            throw ex;
        }
    }
    
    @Override
    public void onFilterPressed() {
        try{
            mainView.setFilterColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onFilterReleased() {
        try{
            mainView.resetFilterColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }
    
    @Override
    public void onViewModeClicked() {
        //Switch view mode between NormaL and Functional
        String viewMode = model.getViewMode();
        
        try{
            if(viewMode.equals(ViewModeUtils.VIEW_MODE_NORMAL)){ //Set Functional mode
                mainView.resetViewModeColor();
                model.setViewMode(ViewModeUtils.VIEW_MODE_FUNCTIONAL);
                model.setCellsViewMode(new FunctionalViewMode());
            }else{ //Set Normal mode
                mainView.setViewModeColor();
                model.setViewMode(ViewModeUtils.VIEW_MODE_NORMAL);
                model.setCellsViewMode(new NormalViewMode());
            }
            model.updateCells();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onExitClicked() {
        try{
            mainView.exitSystem();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onExitPressed() {
        try{
            mainView.setExitColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onExitReleased() {
        try{
            mainView.resetExitColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onRedoClicked() {
        try{
            model.redo();    
            model.updateCells();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onRedoPressed() {
        try{
            mainView.setRedoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onRedoReleased() {
        try{
            mainView.resetRedoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onUndoClicked() {
        try{
            model.undo();    
            model.updateCells();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onUndoPressed() {
        try{
            mainView.setUndoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onUndoReleased() {
        try{
            mainView.resetUndoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onSheetClicked() {
        try{
            mainView.setSheetColor();
            mainView.resetOptionsColor();
            mainView.hideOptionsPanel();
            mainView.ShowSheetPanel();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onOptionsClicked() {
        try{
            mainView.setOptionsColor();
            mainView.resetSheetColor();
            mainView.hideSheetPanel();
           mainView.ShowOptionsPanel();   
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onHeaderPressed(int x, int y) {
        try{
            mainView.setWindowPressedCoordinates(x, y);
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onHeaderDragged(int x, int y) {
        try{
            mainView.setWindowDraggedCoordinates(x, y);
            int xx = mainView.getXX();
            int yy = mainView.getYY();
            mainView.setWindowLocation(x - xx, y - yy);
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onPlayMacroClicked() {
        model.playMacro();
    }

    @Override
    public void onPlayMacroPressed() {
        mainView.setPlayMacroColor();
    }

    @Override
    public void onPlayMacroReleased() {
        mainView.resetPlayMacroColor();
    }

    @Override
    public void onRecordMacroClicked() {
        if(model.isRecordingMacro()){
            model.setRecordingMacro(false);
            mainView.resetRecordMacroColor();
        }else{
            model.clearMacro();
            model.setRecordingMacro(true);
            mainView.setRecordMacroColor();
        }
    }
 
}
