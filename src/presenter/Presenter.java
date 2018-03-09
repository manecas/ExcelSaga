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
import view.IView;

//PRESENTER
public class Presenter implements IPresenter {

    private IView view;
    private IModel model;
    
    public Presenter(IView view) {
        this.view = view;
        this.model = new Model(this);
    }
    
    @Override
    public void setTableModel() {
        try{
            view.setTableModel((TableModel) model);
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onViewModeClicked(String viewMode) {

        //Switch view mode between NormaL and Functional
        try{
            if(viewMode.equals(ViewModeUtils.VIEW_MODE_NORMAL)){ //Set Functional mode
                view.resetViewModeColor();
                view.setViewMode(ViewModeUtils.VIEW_MODE_FUNCTIONAL);
                model.setCellsViewMode(new FunctionalViewMode());
            }else{ //Set Normal mode
                view.setViewModeColor();
                view.setViewMode(ViewModeUtils.VIEW_MODE_NORMAL);
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
            view.exitSystem();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onExitPressed() {
        try{
            view.setExitColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onExitReleased() {
        try{
            view.resetExitColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onRedoClicked() {
        
    }

    @Override
    public void onRedoPressed() {
        try{
            view.setRedoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onRedoReleased() {
        try{
            view.resetRedoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onUndoClicked() {
        
    }

    @Override
    public void onUndoPressed() {
        try{
            view.setUndoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onUndoReleased() {
        try{
            view.resetUndoColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onSheetClicked() {
        try{
            view.setSheetColor();
            view.resetOptionsColor();
            view.hideOptionsPanel();
            view.ShowSheetPanel();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onOptionsClicked() {
        try{
            view.setOptionsColor();
            view.resetSheetColor();
            view.hideSheetPanel();
           view.ShowOptionsPanel();   
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onHeaderPressed(int x, int y) {
        try{
            view.setWindowPressedCoordinates(x, y);
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onHeaderDragged(int x, int y) {
        try{
            view.setWindowDraggedCoordinates(x, y);
            int xx = view.getXX();
            int yy = view.getYY();
            view.setWindowLocation(x - xx, y - yy);
        }catch(NullPointerException ex){
            throw ex;
        }
    }
    
}
