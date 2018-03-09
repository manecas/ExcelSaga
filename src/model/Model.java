/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.operations.AbstractOperationFactory;
import model.operations.Operation;
import model.viewmode.IViewModeStrategy;
import presenter.IPresenter;

/**
 *
 * @author Luis
 */
public class Model extends AbstractTableModel implements IModel {
    
    public final static int TABLE_ROWS = 10;
    public final static int TABLE_COLUMNS = 8;
    
    private IPresenter presenter;
    private Cell[][] table;
    
    public Model(IPresenter presenter) {
        this.presenter = presenter;
        initTable();
    }
    
    private void initTable(){
        table = new Cell[TABLE_ROWS][TABLE_COLUMNS];
        
        for (int i = 0; i < TABLE_ROWS; i++) {
            for (int j = 0; j < TABLE_COLUMNS; j++) {
                String cellId = getCellId(i, j);
                table[i][j] = new Cell(cellId, i, j);
                System.out.print(cellId + " ");
            }
            System.out.println("");
        }
    }

    private String getCellId(int row, int column){
        return getColumnName(column) + (++row);
    }
    
    @Override
    public int getRowCount() {
        return TABLE_ROWS;                                                                  
    }

    @Override
    public int getColumnCount() {
        return TABLE_COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String) table[rowIndex][columnIndex].getViewModeValue();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Cell c = table[rowIndex][columnIndex];

        try{
            c.setValue((String) value);
        }catch(NullPointerException ex){
            throw ex;
        }
        
        AbstractOperationFactory factory = AbstractOperationFactory
                .getOperationFactory((String) value);
        
        Operation operation = null;
        
        if(factory != null){
            operation = factory.getOperation(c, this);
        }
                
        c.setOperation(operation);
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void updateCells() {
        fireTableDataChanged();
    }

    @Override
    public Cell findCellById(String id) {
        for (int i = 0; i < TABLE_ROWS; i++) {
            for (int j = 0; j < TABLE_COLUMNS; j++) {
                if(table[i][j].getId().equals(id)){
                    return table[i][j];
                }
            }
        }
        
        return null;
    }
    
    @Override
    public List<Cell> getRangeOfCells(int row1, int column1, int row2, int column2) {
        List<Cell> involvedCells = new ArrayList<>();
        
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                involvedCells.add(table[i][j]);
            }
        }
        
        return involvedCells;
    }
    
    @Override
    public List<Cell> getRanfeOfCells(String[] cellIds) {
        List<Cell> involvedCells = new ArrayList<>();
        
        for (String cellId : cellIds) {
            Cell c = findCellById(cellId);
            involvedCells.add(c);
        }
        
        return involvedCells;
    }
    
    @Override
    public void setCellsViewMode(IViewModeStrategy viewMode) {
        for (int i = 0; i < TABLE_ROWS; i++) {
            for (int j = 0; j < TABLE_COLUMNS; j++) {
                table[i][j].setViewMode(viewMode);
            }
        }
    }

    
    
}
