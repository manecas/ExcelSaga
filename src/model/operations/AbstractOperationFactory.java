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
    
    private final static String OPERATION_SUM = "=SUM";
    private final static String OPERATION_COPY = "=COPY";
    private final static String OPERATION_NUMBER = "=NUMBER";
    private final static String OPERATION_UPPER = "=UPPER";
    
    public static AbstractOperationFactory getOperationFactory(String arg){
        
        if(!arg.startsWith("=")){
            return null;
        }
        
        String type = arg.split(" ")[0];
        
        switch(type){
            case OPERATION_SUM: return new SumOperationFactory();
            case OPERATION_COPY: return new CopyOperationFactory();
            case OPERATION_NUMBER: return new NumberOperationFactory();
            case OPERATION_UPPER: return new UpperOperationFactory();
        }
        
        return null;
    }
    
    public abstract Operation getOperation(Cell myCell, IModel model);
    
}
