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
public class setSell implements ICommand {

    private Cell currentCell;
    private Cell lastCell;

    public setSell(Cell currentCell) {
        this.currentCell = currentCell;
    }
    
    @Override
    public void doIt(Model model) {
        lastCell = model.getLastModifiedCell();
        model.setCell(currentCell);
    }

    @Override
    public void undoIt(Model model) {
        model.setCell(lastCell);
    }
    
}
