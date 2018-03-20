/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.util.List;
import model.IModel;
import model.filters.EqualFilterDecorator;
import model.filters.Filter;
import model.filters.FilterFactory;
import model.filters.InferiorFilterDecorator;
import model.filters.SuperiorFilterDecotator;
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
            model.clearSelectedFilters();
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
            if(filterView.isSuperiorSelected() 
                    || filterView.isEqualSelected()
                    || filterView.isInferiorSelected()){
                filterView.showMessageDialog("Parameter value not valid!");
                return;
            }
        }
        
        Filter decoratedCell = 
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
        model.addFilter(FilterFactory.getFilter(Filter.UPPER));
    }

    @Override
    public void onUpperDeselected() {
        model.removeFilter(Filter.UPPER);
    }

    @Override
    public void onPositiveSelected() {
        model.addFilter(FilterFactory.getFilter(Filter.POSITIVE));
        
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
        model.addFilter(FilterFactory.getFilter(Filter.NEGATIVE));
        
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
        model.addFilter(FilterFactory.getFilter(Filter.SUPERIOR));
        
        if(filterView.isEqualSelected()){
            filterView.deselectEqual();
        }
        
        if(filterView.isInferiorSelected()){
            filterView.deselectInferior();
        }
        
        filterView.setParamaterTextEditable();
    }

    @Override
    public void onSuperiorDeselected() {
        model.removeFilter(Filter.SUPERIOR);
        
        if(!filterView.isEqualSelected()
                && !filterView.isInferiorSelected()){
            filterView.setParamaterTextNotEditable();
        }
        
    }

    @Override
    public void onEqualSelected() {
        model.addFilter(FilterFactory.getFilter(Filter.EQUAL));
        
        if(filterView.isSuperiorSelected()){
            filterView.deselectSuperior();
        }
        
        if(filterView.isInferiorSelected()){
            filterView.deselectInferior();
        }
        
        filterView.setParamaterTextEditable();
    }

    @Override
    public void onEqualDeselected() {
        model.removeFilter(Filter.EQUAL);
        
        if(!filterView.isSuperiorSelected()
                && !filterView.isInferiorSelected()){
            filterView.setParamaterTextNotEditable();
        }
    }

    @Override
    public void onInferiorSelected() {
        model.addFilter(FilterFactory.getFilter(Filter.INFERIOR));
        
        if(filterView.isSuperiorSelected()){
            filterView.deselectSuperior();
        }
        
        if(filterView.isEqualSelected()){
            filterView.deselectEqual();
        }
        
        filterView.setParamaterTextEditable();
    }

    @Override
    public void onInferiorDeselected() {
        model.removeFilter(Filter.INFERIOR);
        
        if(!filterView.isEqualSelected()
                && !filterView.isInferiorSelected()){
            filterView.setParamaterTextNotEditable();
        }
    }
 
    @Override
    public void onWindowLoad() {
        List<Filter> selectedFilters = model.getSelectedCellFilters();
        
        filterView.setWindowLoading(true);
        
        for (Filter f : selectedFilters) {
            switch(f.getType()){
                case Filter.UPPER: 
                    filterView.selectUpper();
                    break;
                case Filter.POSITIVE: 
                    filterView.selectPositive();
                    break;
                case Filter.NEGATIVE: 
                    filterView.selectNegative();
                    break;
                case Filter.SUPERIOR: 
                    filterView.selectSuperior();
                    filterView.SetParameterText(((SuperiorFilterDecotator) f).getXAsString());
                    break;
                case Filter.EQUAL: 
                    filterView.selectEqual();
                    filterView.SetParameterText(((EqualFilterDecorator) f).getXAsString());
                    break;
                case Filter.INFERIOR: 
                    filterView.selectInferior();
                    filterView.SetParameterText(((InferiorFilterDecorator) f).getXAsString());
                    break;
            }
        }
        
        filterView.setWindowLoading(false);
        
        if(!filterView.isSuperiorSelected()
                && !filterView.isEqualSelected()
                && !filterView.isInferiorSelected()){
            filterView.setParamaterTextNotEditable();
        }
    }
    
}
