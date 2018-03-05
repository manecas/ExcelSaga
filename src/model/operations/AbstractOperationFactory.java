/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

/**
 *
 * @author Luis
 */
public abstract class AbstractOperationFactory {
    
    public final static String OPERATION_SUM = "=SOMA";
    public final static String OPERATION_COPY = "=COPY";
    public final static String OPERATION_NUMBER = "=NUMBER";
    public final static String OPERATION_UPPER = "=UPPER";
    
    public AbstractOperationFactory getOperationFactory(String type){
        
        switch(type){
            case OPERATION_SUM:
                break;
            case OPERATION_COPY:
                break;
            case OPERATION_NUMBER:
                break;
            case OPERATION_UPPER:
                break;
        }
        
        return null;
        
    }
    
}
