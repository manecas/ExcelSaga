/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import presenter.IFilterPresenter;

/**
 *
 * @author Luis
 */
public interface IFilterView {
    
    void setPresenter(IFilterPresenter filterPresenter);
    
    void closeWindow();
    void setExitColor();
    void resetExitColor();
    
    void setWindowPressedCoordinates(int x, int y);
    void setWindowDraggedCoordinates(int x, int y);
    void setWindowLocation(int x, int y);
    int getXX();
    int getYY();
    int getX();
    int getY();
    
}
