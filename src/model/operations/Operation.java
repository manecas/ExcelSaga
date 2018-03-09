/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

import java.util.List;
import model.Cell;
import model.IModel;

/**
 *
 * @author Luis
 */

//Template
public abstract class Operation {

    private Cell myCell;
    private List<Cell> involvedCells;
    private boolean performedOperation;
    
    public Operation(Cell myCell, IModel model) {
        this.myCell = myCell;
        this.performedOperation = false;
        init(model);
    }
    
    abstract void performOperation(String value);
    
    abstract String getValue();
    
    public String getOperationValue(){
        if(!performedOperation){
            performedOperation = true;
            
            for (Cell c : involvedCells) {
                if(c.getOperation() !=  null){
                    performOperation(c.getOperationValue());
                }else{
                    performOperation(c.getValue());
                }
            }
        }
        
        return getValue();
    }
    
    private void init(IModel model){
        
        String []args = myCell.getValue().trim().split(" ", 2);
        
        if(args.length <= 1){
            return;
        }
        
        if(args[1].contains(":")){
            
            String []cellIds = args[1].split(":");
            cellIds = trimArraySpaces(cellIds);
            
            if(cellIds.length != 2){
                return;
            }
            
            Cell c1 = model.findCellById(cellIds[0]);
            Cell c2 = model.findCellById(cellIds[1]);
                    
            try {
                
                involvedCells = model.getRangeOfCells(c1.getRow(), 
                        c1.getColumn(), c2.getRow(), c2.getColumn());
                
            } catch (NullPointerException ex) {
                throw ex;
            }
            
        }else{
            
            String []cellIds = args[1].split(" ");
            cellIds = trimArraySpaces(cellIds);
            
            if(cellIds.length == 0){
                return;
            }
            
            involvedCells = model.getRanfeOfCells(cellIds);
            
        }
        
    }
    
    private String[] trimArraySpaces(String []array){
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
        
        return array;
    }
    
}
