/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.viewmode;

import model.Cell;

/**
 *
 * @author Luis
 */
public class NormalViewMode implements IViewModeStrategy {

    @Override
    public String getCellModeValue(Cell c) {
        return c.getValue() + " - Normal";
    }
    
}
