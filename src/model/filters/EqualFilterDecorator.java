/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.filters;

import model.Cell;
import model.operations.InvolvedCellsChangeListener;
import model.operations.Operation;
import model.viewmode.IViewModeStrategy;

/**
 *
 * @author Luis
 */ 
public class EqualFilterDecorator extends Filter {

    private double x;
    
    public EqualFilterDecorator(Filter nextCell, double x) {
        super(nextCell, Filter.EQUAL);
        this.x = x;
    }

    @Override
    public String getFilteredValue() {
        double value = 0;
        
        try{
            value = Double.parseDouble(getNextCell().getFilteredValue());
        }catch(NumberFormatException ex){
            System.out.println("getFilteredValue(): It's ok if it's not a number");
            return "";
        }catch(NullPointerException ex){
            throw ex;
        }
        
        return value == x ? String.valueOf(value) :  "";
    }

    @Override
    public String getViewModeValue() {
        return getNextCell().getViewModeValue();
    }

    @Override
    public String getOperationValue() {
        return getNextCell().getOperationValue();
    }

    @Override
    public int getRow() {
        return getNextCell().getRow();
    }

    @Override
    public void setRow(int row) {
        getNextCell().setRow(row);
    }

    @Override
    public int getColumn() {
        return getNextCell().getColumn();
    }

    @Override
    public void setColumn(int column) {
        getNextCell().setColumn(column);
    }

    @Override
    public String getId() {
        return getNextCell().getId();
    }

    @Override
    public void setId(String id) {
        getNextCell().setId(id);
    }

    @Override
    public String getValue() {
        return getNextCell().getValue();
    }

    @Override
    public void setValue(String value) {
        getNextCell().setValue(value);
    }
    
    @Override
    public Operation getOperation() {
        return getNextCell().getOperation();
    }

    @Override
    public void setOperation(Operation operation) {
        getNextCell().setOperation(operation);
    }

    @Override
    public IViewModeStrategy getViewMode() {
        return getNextCell().getViewMode();
    }

    @Override
    public void setViewMode(IViewModeStrategy viewMode) {
        getNextCell().setViewMode(viewMode);
    }

    @Override
    public Cell getOriginalCell() {
        return getNextCell().getOriginalCell();
    }

    @Override
    public Filter getCopy() {
        return new EqualFilterDecorator(getNextCell(), x);
    }

    @Override
    public void addInvolvedCellsChangeListener(InvolvedCellsChangeListener listener) {
        getNextCell().addInvolvedCellsChangeListener(listener);
    }

    @Override
    public void removeInvolvedCellsListeners() {
        getNextCell().removeInvolvedCellsListeners();
    }
    
}
