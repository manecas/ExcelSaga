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
public class NumberOperationFactory extends AbstractOperationFactory {

    @Override
    public Operation getOperation(Cell myCell, IModel model) {
        return new NumberOperation(myCell, model);
    }
    
}
