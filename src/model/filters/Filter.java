/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.filters;

import java.util.Objects;
import model.Cell;
import model.operations.InvolvedCellsChangeListener;
import model.operations.Operation;
import model.viewmode.IViewModeStrategy;

/**
 *
 * @author Luis
 */
public abstract class Filter {
    
    public final static String UPPER = "UPPER";
    public final static String INFERIOR = "INFERIOR";
    public final static String EQUAL = "EQUAL";
    public final static String SUPERIOR = "SUPERIOR";
    public final static String NEGATIVE = "NEGATIVE";
    public final static String POSITIVE = "POSITIVE";
    
    private Filter nextCell;
    private final String type;

    public Filter(String type) {
        this.type = type;
    }

    public Filter(Filter toCopy) {
        if(toCopy != null){
            this.nextCell = toCopy.nextCell.getCopy();
        }else{
            this.nextCell = null;
        }
        
        if(toCopy.type != null){
            this.type = toCopy.type;
        }else{
            this.type = null;
        }
    }
    
    public Filter(Filter nextCell, String type) {
        this.nextCell = nextCell;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filter other = (Filter) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
    
    public abstract String getFilteredValue();
    
    public abstract String getViewModeValue();
    
    public abstract String getOperationValue();

    public abstract int getRow();

    public abstract void setRow(int row);

    public abstract int getColumn();

    public abstract void setColumn(int column);

    public abstract String getId();

    public abstract void setId(String id);

    public abstract String getValue();
   
    public abstract void setValue(String value);
    
    public abstract Operation getOperation();

    public abstract void setOperation(Operation operation);

    public abstract IViewModeStrategy getViewMode();

    public abstract void setViewMode(IViewModeStrategy viewMode);
    
    public abstract Cell getOriginalCell();
    
    public abstract Filter getCopy();
    
    public abstract void addInvolvedCellsChangeListener(InvolvedCellsChangeListener listener);
    
    public abstract void removeInvolvedCellsListeners();

    public Filter getNextCell() {
        return nextCell;
    }

    public void setNextCell(Filter nextCell) {
        this.nextCell = nextCell;
    }

    public String getType() {
        return type;
    }
    
}
