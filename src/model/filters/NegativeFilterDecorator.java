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
public class NegativeFilterDecorator extends Filter {

    public NegativeFilterDecorator(Cell nextCell) {
        super(nextCell);
    }

    @Override
    public String getFilteredValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
