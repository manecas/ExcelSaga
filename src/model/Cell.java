/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.operations.Operation;
import model.viewmode.IViewModeStrategy;
import utils.ViewModeUtils;

/**
 *
 * @author Luis
 */
public class Cell {
    
    private int row;
    private int column;
    private String id;
    private IViewModeStrategy viewMode;
    private Operation operation;
    private String value;

    public Cell(String id, int row, int column) {
        this.id = id;
        this.row = row;
        this.column = column;
        viewMode = ViewModeUtils.getDefaultViewModeStrategy();
        operation = null;
        value = "";
    }
    
    public String getViewModeValue(){
        return viewMode.getCellModeValue(this);
    }
    
    public String getOperationValue(){
        if(operation != null){
            return operation.getOperationValue();
        }
        
        return value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public IViewModeStrategy getViewMode() {
        return viewMode;
    }

    public void setViewMode(IViewModeStrategy viewMode) {
        this.viewMode = viewMode;
    }
    
}
