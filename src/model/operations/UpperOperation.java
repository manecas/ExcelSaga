/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

import model.Cell;
import model.IModel;

/**
 *
 * @author Luis
 */
public class UpperOperation extends Operation {

    private String value;
    
    public UpperOperation(Cell myCell, IModel model) {
        super(myCell, model);
    }

    @Override
    void performOperation(String value) {
        this.value = value.toUpperCase();
    }

    @Override
    String getValue() {
        return value;
    }
    
}
