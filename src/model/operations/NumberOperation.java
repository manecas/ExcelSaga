/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

import model.Cell;

/**
 *
 * @author Luis
 */
public class NumberOperation extends Operation {

    public NumberOperation(Cell myCell, String operation) {
        super(myCell, operation);
    }

    @Override
    void getFinalResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
