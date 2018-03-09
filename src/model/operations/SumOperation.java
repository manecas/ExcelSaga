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
public class SumOperation extends Operation {

    private double value;
    
    public SumOperation(Cell myCell, IModel model) {
        super(myCell, model);
    }

    @Override
    void performOperation(String value) {
        try{
            this.value += Double.parseDouble(value);    
        }catch(NullPointerException ex){
            System.out.println("It's not a float value, but it's ok. "
                    + "Nothing happens then");
        }
    }

    @Override
    String getValue() {
        return String.valueOf(value);
    }
    
}
