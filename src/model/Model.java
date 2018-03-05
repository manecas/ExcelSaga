/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.AbstractTableModel;
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
    //View
    
    public Model(IPresenter presenter) {
        this.presenter = presenter;
        initTable();
    }
    
    private void initTable(){
        
        table = new Cell[TABLE_ROWS][TABLE_COLUMNS];
        
        for (int i = 0; i < TABLE_ROWS; i++) {
            for (int j = 0; j < TABLE_COLUMNS; j++) {
                table[i][j] = new Cell();
            }
        }
        
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
        return (String) table[rowIndex][columnIndex].getValue();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        
        Cell c = table[rowIndex][columnIndex];
        
        try{
            c.setValue((String) value);
        }catch(NullPointerException e){
            System.out.println("Model: setValueAt:\n" + e.toString());
        }
        
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
    
}
