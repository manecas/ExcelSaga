/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

import model.Cell;
import model.IModel;
import model.filters.Filter;

/**
 *
 * @author Luis
 */
public class UpperOperation extends Operation {

    private String value;
    
    public UpperOperation(Filter myCell, IModel model) {
        super(myCell, model);
        value = "";
    }

    @Override
    void performOperation(String value) {
        this.value = value.toUpperCase();
    }

    @Override
    String getValue() {
        String originalValue = value;
        value = "";
        
        return originalValue;
    }
    
    @Override
    public void updateInvolvedCells() {
        init(getModel());
        value = "";
    }
    
}
