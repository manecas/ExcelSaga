/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

import java.util.ArrayList;
import java.util.List;
import model.Cell;
import model.IModel;
import model.filters.Filter;

/**
 *
 * @author Luis
 */

//Template
public abstract class Operation implements InvolvedCellsChangeListener {

    public final static String SUM = "=SUM";
    public final static String COPY = "=COPY";
    public final static String NUMBER = "=NUMBER";
    public final static String UPPER = "=UPPER";
    
    private Filter myCell;
    private List<Filter> involvedCells;
    private IModel model;
    
    public Operation(Filter myCell, IModel model) {
        this.myCell = myCell;
        this.involvedCells = new ArrayList<>();
        this.model = model;
        init(model);

    }
    
    abstract void performOperation(String value);
    
    abstract String getValue();
    
    public String getOperationValue(){
        for (Filter cell : involvedCells) {
            performOperation(cell.getOperationValue());
            cell.addInvolvedCellsChangeListener(this);
        }
        
        return getValue();
    }
    
    protected void init(IModel model){
        clearInvolvedCellsListeners();
        clearInvolvedCells();
        
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
            
            Filter c1 = model.findCellById(cellIds[0]);
            Filter c2 = model.findCellById(cellIds[1]);
                    
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

    public void clearInvolvedCells(){
        involvedCells.clear();
    }
    
    public void clearInvolvedCellsListeners(){
        myCell.removeInvolvedCellsListeners();
    }
    
    public Filter getMyCell() {
        return myCell;
    }

    public void setMyCell(Filter myCell) {
        this.myCell = myCell;
    }

    public IModel getModel() {
        return model;
    }

    public void setModel(IModel model) {
        this.model = model;
    }
    
}
