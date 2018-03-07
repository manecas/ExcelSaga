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
public class CopyOperationFactory extends AbstractOperationFactory {

    @Override
    Operation getOperation(Cell myCell, String operation) {
        return new CopyOperation(myCell, operation);
    }
    
}
