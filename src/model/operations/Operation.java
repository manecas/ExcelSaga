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

//Template
public abstract class Operation {

    private Cell myCell;
    
    public Operation(Cell myCell, String operation) {
        this.myCell = myCell;
    }
    
    abstract void getFinalResult();
    
}
