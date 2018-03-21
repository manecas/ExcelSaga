/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

import model.IModel;
import model.filters.Filter;

/**
 *
 * @author Luis
 */
public class CopyOperation extends Operation {

    private String value;
    
    public CopyOperation(Filter myCell, IModel model){
        super(myCell, model);
        value = "";
    }
    
    @Override
    void performOperation(String value) {
        this.value = value;
    }

    @Override
    String getValue() {
        String originalValue = value;
        value = "";
        
        return originalValue;
    }

    @Override
    public void updateInvolvedCells() {
        findInvolvedCells();
        getModel().updateCells();
    }
    
}
