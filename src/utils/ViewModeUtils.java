/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.viewmode.FunctionalViewMode;
import model.viewmode.IViewModeStrategy;
import model.viewmode.NormalViewMode;

/**
 *
 * @author Luis
 */
public final class ViewModeUtils {

    public final static String VIEW_MODE_NORMAL = "NORMAL";
    public final static String VIEW_MODE_FUNCTIONAL = "FUNCTIONAL";
    
    private final static String DEFAULT_VIEW_MODE = VIEW_MODE_FUNCTIONAL;
    
    private ViewModeUtils() {
    }
    
    public static String getDefaultViewMode(){
        return DEFAULT_VIEW_MODE;
    }
    
    public static IViewModeStrategy getDefaultViewModeStrategy(){
        if(DEFAULT_VIEW_MODE.equals(VIEW_MODE_NORMAL)){
            return new NormalViewMode();
        }else{
            return new FunctionalViewMode();
        }
    }
    
}
