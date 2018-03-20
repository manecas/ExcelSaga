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
public abstract class Filter {
    
    public final static String UPPER = "UPPER";
    public final static String INFERIOR = "INFERIOR";
    public final static String EQUAL = "EQUAL";
    public final static String SUPERIOR = "SUPERIOR";
    public final static String NEGATIVE = "NEGATIVE";
    public final static String POSITIVE = "POSITIVE";
    
    private Filter nextCell;
    private final String type;

    public Filter(Filter toCopy){
        this.nextCell = toCopy.nextCell;
        this.type = toCopy.type;
    }
    
    public Filter(Filter nextCell, String type) {
        this.nextCell = nextCell;
        this.type = null;
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
