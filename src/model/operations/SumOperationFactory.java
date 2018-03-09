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
public class SumOperationFactory extends AbstractOperationFactory {

    @Override
    public Operation getOperation(Cell myCell, IModel model) {
        return new SumOperation(myCell, model);
    }
    
}
