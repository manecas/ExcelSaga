/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.Cell;
import model.IModel;
import model.filters.Filter;
import model.filters.NegativeFilterDecorator;
import model.filters.PositiveFilterDecotator;
import model.filters.UpperFilterDecotator;
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

    @Override
    public void onConfirmClicked() {
        String parameter = filterView.getParameterText();
        double x = 0;
        
        try{
            x = Double.parseDouble(parameter);
        }catch(NumberFormatException ex){
            filterView.showMessageDialog("Parameter value not valid!");
            return;
        }
        
        Cell decoratedCell = 
                model.getDecoratedCell(model.getCellToDecorate(), x);
        model.setSelectedCell(decoratedCell);
        model.updateSelectedCell();
        model.setSelectedCellRowColumn(-1, -1);
        model.clearSelectedFilters();
        filterView.closeWindow();
    }

    @Override
    public void onConfirmPressed() {
        filterView.setConfirmColor();
    }

    @Override
    public void onConfirmReleased() {
        filterView.resetConfirmColor();
    }

    @Override
    public void onUpperSelected() {
        model.addFilter(Filter.UPPER);
    }

    @Override
    public void onUpperDeselected() {
        model.removeFilter(Filter.UPPER);
    }

    @Override
    public void onPositiveSelected() {
        model.addFilter(Filter.POSITIVE);
        
        if(filterView.isNegativeSelected()){
            filterView.deselectNegative();
        }
    }

    @Override
    public void onPositiveDeselected() {
        model.removeFilter(Filter.POSITIVE);
    }

    @Override
    public void onNegativeSelected() {
        model.addFilter(Filter.NEGATIVE);
        
        if(filterView.isPositiveSelected()){
            filterView.deselectPositive();
        }
    }

    @Override
    public void onNegativeDeselected() {
        model.removeFilter(Filter.NEGATIVE);
    }

    @Override
    public void onSuperiorSelected() {
        model.addFilter(Filter.SUPERIOR);
        
        if(filterView.isEqualSelected()){
            filterView.deselectEqual();
        }
        
        if(filterView.isInferiorSelected()){
            filterView.deselectInferior();
        }
    }

    @Override
    public void onSuperiorDeselected() {
        model.removeFilter(Filter.SUPERIOR);
    }

    @Override
    public void onEqualSelected() {
        model.addFilter(Filter.EQUAL);
        
        if(filterView.isSuperiorSelected()){
            filterView.deselectSuperior();
        }
        
        if(filterView.isInferiorSelected()){
            filterView.deselectInferior();
        }
    }

    @Override
    public void onEqualDeselected() {
        model.removeFilter(Filter.EQUAL);
    }

    @Override
    public void onInferiorSelected() {
        model.addFilter(Filter.INFERIOR);
        
        if(filterView.isSuperiorSelected()){
            filterView.deselectSuperior();
        }
        
        if(filterView.isEqualSelected()){
            filterView.deselectEqual();
        }
    }

    @Override
    public void onInferiorDeselected() {
        model.removeFilter(Filter.INFERIOR);
    }
    
}
