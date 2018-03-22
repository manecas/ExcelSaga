/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.AbstractTableModel;
import static model.Model.TABLE_COLUMNS;
import static model.Model.TABLE_ROWS;
import model.command.setCell;
import model.filters.Filter;
import model.operations.AbstractOperationFactory;
import model.operations.Operation;

/**
 *
 * @author Luis
 */
public class AbsTableModel extends AbstractTableModel {

    private IModel model;
    
    public AbsTableModel(IModel model) {
        this.model = model;
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
        Filter cell = model.getSheet()[rowIndex][columnIndex];
        
        if(!(cell instanceof Cell)){
            return cell.getFilteredValue(); 
        }
        
        return cell.getViewModeValue();
    }
 
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Filter currentCell =  model.getSheet()[rowIndex][columnIndex];

        if(currentCell.getValue().equals((String) value)){
            return;
        }
        
        Filter oldCell = currentCell.getCopy();
         
        try{
            currentCell.setValue((String) value);
        }catch(NullPointerException ex){
            throw ex;
        }
        
        AbstractOperationFactory factory = AbstractOperationFactory
                .getOperationFactory((String) value);
        
        Operation operation = null;
        
        if(factory != null){
            operation = factory.getOperation(currentCell, model);
        }

        if(operation != null){
            currentCell.setOperation(operation);
            currentCell.getOperation().findInvolvedCells();
        }
        
        if(model.getMacro().isRecordingMacro()){
            model.getMacro().addCommand(new setCell(currentCell.getCopy(), oldCell.getCopy()));
        }
        
        model.getCmdManager().apply(new setCell(currentCell.getCopy(), oldCell.getCopy()));
        
        currentCell.getOriginalCell().updateListeners();
        
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
    
    public void updateCells() {
        fireTableDataChanged();
    }
    
    public void updateSelectedCell(int selectedRow, int selectedColumn) {
        fireTableCellUpdated(selectedRow, selectedColumn);
    }
    
    public String getCellId(int row, int column){
        return getColumnName(column) + (++row);
    }
    
}
