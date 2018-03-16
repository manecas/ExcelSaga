/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.filters;

import model.Cell;

/**
 *
 * @author Luis
 */ 
public class EqualFilterDecorator extends Filter {

    private double x;
    
    public EqualFilterDecorator(Cell nextCell, double x) {
        super(nextCell);
        this.x = x;
    }

    @Override
    public String getFilteredValue() {
        Cell nextCell = getNextCell();
        
        double value = 0;
        
        try{
            if(nextCell.getOperation() != null){
                value = Double.parseDouble(nextCell.getOperationValue());
            }else{
                value = Double.parseDouble(nextCell.getValue());
            }
        }catch(NumberFormatException ex){
            System.out.println("getFilteredValue(): It's ok if it's not a number");
            return nextCell.getValue();
        }catch(NullPointerException ex){
            throw ex;
        }
        
        return value == x ? String.valueOf(value) :  "";
    }
    
    
}
