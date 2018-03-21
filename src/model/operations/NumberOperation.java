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
public class NumberOperation extends Operation {

    public NumberOperation(Filter myCell, IModel model) {
        super(myCell, model);
    }

    @Override
    void performOperation(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateInvolvedCells() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
