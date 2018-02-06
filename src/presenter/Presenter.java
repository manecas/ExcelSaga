/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import javax.swing.table.AbstractTableModel;
import model.Cell;
import model.Model;
import model.IModel;
import utils.Constants;
import view.IView;

//PRESENTER
public class Presenter extends AbstractTableModel implements IPresenter {

    private IView view;
    private IModel model;
    
    public Presenter(IView view) {
        this.view = view;
        this.model = new Model(this);
    }
    
    @Override
    public int getRowCount() {
        return Constants.TABLE_ROWS;                                                                  
    }

    @Override
    public int getColumnCount() {
        return Constants.TABLE_COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String)model.getValueAt(rowIndex, columnIndex).getValue();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        model.setValueAt((String)value, rowIndex, columnIndex);
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
    
}
