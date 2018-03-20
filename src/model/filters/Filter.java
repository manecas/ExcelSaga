/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.filters;

import model.Cell;
import model.operations.Operation;
import model.viewmode.IViewModeStrategy;

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
    private Cell oldCell;
    private String type;
    
    public abstract String getFilteredValue();

    public Filter(Cell nextCell, String type) {
        this.nextCell = nextCell;
        this.type = type;
    }

    @Override
    public String getViewModeValue() {
        return nextCell.getViewModeValue(); 
    }

    @Override
    public String getOperationValue() {
        return nextCell.getOperationValue();
    }

    @Override
    public Operation getOperation() {
        return nextCell.getOperation();
    }

    @Override
    public void setValue(String value) {
        nextCell.setValue(value);
    }

    @Override
    public String getValue() {
        return nextCell.getValue();
    }

    @Override
    public void setViewMode(IViewModeStrategy viewMode) {
        nextCell.setViewMode(viewMode);
    }
    
    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }

    public Cell getOldCell() {
        return oldCell;
    }

    public void setOldCell(Cell oldCell) {
        this.oldCell = oldCell;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
