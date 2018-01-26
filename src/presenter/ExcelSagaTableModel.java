/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import javax.swing.table.AbstractTableModel;
import model.ExcelSagaModel;
import model.IModel;
import view.IView;

//PRESENTER
public class ExcelSagaTableModel extends AbstractTableModel implements IPresenter {

    private IView view;
    private IModel model;
    
    public ExcelSagaTableModel(IView view) {
        this.view = view;
        this.model = new ExcelSagaModel(this);
    }
    
    @Override
    public int getRowCount() {
        return 10;                                                                  
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
}
