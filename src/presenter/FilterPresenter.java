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
    
}
