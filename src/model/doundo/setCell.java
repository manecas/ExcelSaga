/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.doundo;

import model.Model;
import model.filters.Filter;

/**
 *
 * @author Luis
 */
public class setCell implements ICommand {

    private Filter currentCell;
    private Filter oldCell;

    public setCell(Filter currentCell, Filter oldCell) {
        this.currentCell = currentCell;
        this.oldCell = oldCell;
    }
    
    @Override   
    public void doIt(Model model) {
        model.setCell(currentCell.getCopy());
        System.out.println("doIt(): " + currentCell.getFilteredValue());
    }

    @Override
    public void undoIt(Model model) {
        model.setCell(oldCell.getCopy());
        System.out.println("undoIt(): " + oldCell.getFilteredValue());
    } 
    
}
