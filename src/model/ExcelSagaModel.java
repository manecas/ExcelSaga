/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import presenter.IPresenter;

/**
 *
 * @author Luis
 */
public class ExcelSagaModel implements IModel {

    private IPresenter presenter;
    
    public ExcelSagaModel(IPresenter presenter) {
        this.presenter = presenter;
    }
    
}
