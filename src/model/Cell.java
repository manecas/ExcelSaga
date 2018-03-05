/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.viewmode.IViewModeStrategy;
import utils.ViewModeUtils;

/**
 *
 * @author Luis
 */
public class Cell {
    
    private IViewModeStrategy viewMode;
    private String value;

    public Cell() {
        viewMode = ViewModeUtils.getDefaultViewModeStrategy();
        value = "";
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public IViewModeStrategy getViewMode() {
        return viewMode;
    }

    public void setViewMode(IViewModeStrategy viewMode) {
        this.viewMode = viewMode;
    }
    
}
