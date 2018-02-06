/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import presenter.IPresenter;
import utils.Constants;

/**
 *
 * @author Luis
 */
public class Model implements IModel {
    
    private IPresenter presenter;
    
    private Cell[][] table;
    //View
    
    public Model(IPresenter presenter) {
        this.presenter = presenter;
        initTable();
    }
    
    private void initTable(){
        
        table = new Cell[Constants.TABLE_ROWS][Constants.TABLE_COLUMNS];
        
        for (int i = 0; i < Constants.TABLE_ROWS; i++) {
            for (int j = 0; j < Constants.TABLE_COLUMNS; j++) {
                table[i][j] = new Cell();
            }
        }
        
    }

    @Override
    public Cell getValueAt(int rowIndex, int columnIndex) {
        return table[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(String value, int rowIndex, int columnIndex) {
        
        Cell c = table[rowIndex][columnIndex];
        
        try{
            c.setValue(value);
        }catch(NullPointerException e){
            System.out.println("Model: setValueAt:\n" + e.toString());
        }
        
    }
    
}
