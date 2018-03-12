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
public class CopyOperation extends Operation {

    private String value;
    
    public CopyOperation(Cell myCell, IModel model){
        super(myCell, model);
    }
    
    @Override
    void performOperation(String value) {
        this.value = value;
    }

    @Override
    String getValue() {
        return value;
    }
    
}
