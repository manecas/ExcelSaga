/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.filters.Filter;
import model.operations.InvolvedCellsChangeListener;
import model.operations.Operation;
import model.viewmode.IViewModeStrategy;
import utils.ViewModeUtils;

/**
 *
 * @author Luis
 */
public class Cell extends Filter {
    
    private int row;
    private int column;
    private String id;
    private IViewModeStrategy viewMode;
    private Operation operation;
    private String value;
    private List<InvolvedCellsChangeListener> listeners;

    public Cell(Cell cell){
        super(null, null);
        this.row = cell.row;
        this.column = cell.column;
        this.id = cell.id;
        this.viewMode = cell.viewMode;
        this.operation = cell.operation;
        this.value = cell.value;
        this.listeners = cell.listeners;
    }
    
    public Cell(String id, int row, int column) {
        super(null, null);
        this.id = id;
        this.row = row;
        this.column = column;
        viewMode = ViewModeUtils.getDefaultViewModeStrategy();
        operation = null;
        value = "";
        listeners = new ArrayList<>();
    }
    
    public void updateListeners(){
        for (InvolvedCellsChangeListener listener : listeners) {
            listener.updateInvolvedCells();
        }
    }
    
    @Override
    public String getViewModeValue(){
        return viewMode.getCellModeValue(this);
    }
    
    @Override
    public String getOperationValue(){
        if(operation != null){
            return operation.getOperationValue();
        }
        
        return value;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getValue() {
        return value;
    }
    
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Operation getOperation() {
        return operation;
    }

    @Override
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public IViewModeStrategy getViewMode() {
        return viewMode;
    }

    @Override
    public void setViewMode(IViewModeStrategy viewMode) {
        this.viewMode = viewMode;
    }

    @Override
    public String getFilteredValue() {
        return getOperationValue();
    }

    @Override
    public Cell getOriginalCell() {
        return this;
    }

    @Override
    public Filter getCopy() {
        return new Cell(this);
    }

    @Override
    public void addInvolvedCellsChangeListener(InvolvedCellsChangeListener listener) {
        if(listeners.contains(listener)){
            return;
        }
        
        listeners.add(listener);
    }

    @Override
    public void removeInvolvedCellsListeners() {
        listeners.clear();
    }
    
    

}
