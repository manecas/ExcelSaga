/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.operations;

import model.IModel;
import model.filters.Filter;

/**
 *
 * @author Luis
 */
public class SumOperation extends Operation {

    private double value;
    
    public SumOperation(Filter myCell, IModel model) {
        super(myCell, model);
        value = 0; 
    }

    @Override
    void performOperation(String value) {
        if("".equals(value)){
            return;
        }
        
        try{
            this.value += Double.parseDouble(value);    
        }catch(NullPointerException | NumberFormatException ex){
            System.out.println("It's not a float value, but it's ok. "
                    + "Nothing happens then");
        }
    }

    @Override
    String getValue() {        
        double originalValue = value;
        value = 0;
        
        return String.valueOf(originalValue);
    }
    
    @Override
    public void updateInvolvedCells() {
        findInvolvedCells();
        getModel().updateCells();
    }
    
}
