/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.doundo;

import model.Cell;
import model.Model;

/**
 *
 * @author Luis
 */
public class setCell implements ICommand {

    private Cell currentCell;
    private Cell oldCell;

    public setCell(Cell currentCell, Cell oldCell) {
        this.currentCell = currentCell;
        this.oldCell = oldCell;
    }
    
    @Override
    public void doIt(Model model) {
        model.setCell(new Cell(currentCell));
        System.out.println("doIt(): " + currentCell.getValue());
    }

    @Override
    public void undoIt(Model model) {
        model.setCell(new Cell(oldCell));
        System.out.println("undoIt(): " + oldCell.getValue());
    } 
    
}
