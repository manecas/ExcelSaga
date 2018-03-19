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
public abstract class Filter extends Cell {
    
    public final static String UPPER = "UPPER";
    public final static String INFERIOR = "INFERIOR";
    public final static String EQUAL = "EQUAL";
    public final static String SUPERIOR = "SUPERIOR";
    public final static String NEGATIVE = "NEGATIVE";
    public final static String POSITIVE = "POSITIVE";
    
    private Cell nextCell;
    
    public abstract String getFilteredValue();

    public Filter(Cell nextCell) {
        this.nextCell = nextCell;
    }

    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }

}
