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
public abstract class AbstractOperationFactory {
    
    public static AbstractOperationFactory getOperationFactory(String arg){
        
        if(!arg.startsWith("=")){
            return null;
        }
        
        String type = arg.split(" ")[0];
        
        switch(type){
            case Operation.SUM: return new SumOperationFactory();
            case Operation.COPY: return new CopyOperationFactory();
            case Operation.NUMBER: return new NumberOperationFactory();
            case Operation.UPPER: return new UpperOperationFactory();
        }
        
        return null;
    }
    
    public abstract Operation getOperation(Cell myCell, IModel model);
    
}
