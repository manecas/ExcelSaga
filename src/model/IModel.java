/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luis
 */
public interface IModel {
    
    public Cell getValueAt(int rowIndex, int columnIndex);

    public void setValueAt(String value, int rowIndex, int columnIndex);
    
}
