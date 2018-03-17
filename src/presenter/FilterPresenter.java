/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.IModel;
import view.IFilterView;

/**
 *
 * @author Luis
 */
public class FilterPresenter implements IFilterPresenter {

    private IFilterView filterView;
    private IModel model;
    
    public FilterPresenter(IFilterView filterView, IModel model) {
        this.filterView = filterView;
        this.model = model;
    }
    
    @Override
    public void onExitClicked() {
        try{
            filterView.closeWindow();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onExitPressed() {
        try{
            filterView.setExitColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onExitReleased() {
        try{
            filterView.resetExitColor();
        }catch(NullPointerException ex){
            throw ex;
        }
    }
    
    @Override
    public void onHeaderPressed(int x, int y) {
        try{
            filterView.setWindowPressedCoordinates(x, y);
        }catch(NullPointerException ex){
            throw ex;
        }
    }

    @Override
    public void onHeaderDragged(int x, int y) {
        try{
            filterView.setWindowDraggedCoordinates(x, y);
            int xx = filterView.getXX();
            int yy = filterView.getYY();
            filterView.setWindowLocation(x - xx, y - yy);
        }catch(NullPointerException ex){
            throw ex;
        }
    }
    
}
