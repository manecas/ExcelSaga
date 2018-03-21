/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.filters.Filter;
import utils.ViewModeUtils;

/**
 *
 * @author Luis
 */
public class SheetManager {
    
    private Filter[][] sheet;
    private int selectedRow;
    private int selectedColumn;
    private List<Filter> selectedFilters;
    private String viewMode;

    public SheetManager() {
        this.selectedRow = -1;
        this.selectedColumn = -1;
        this.selectedFilters = new ArrayList<>();
        this.viewMode = ViewModeUtils.getDefaultViewMode();
    }
    
}
