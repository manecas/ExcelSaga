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
    
    void showMessageDialog(String message);
    
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
    
    void setConfirmColor();
    void resetConfirmColor();
    
    boolean isNegativeSelected();
    boolean isPositiveSelected();
    
    boolean isSuperiorSelected();
    boolean isEqualSelected();
    boolean isInferiorSelected();
    
    void deselectNegative();
    void deselectPositive();
    
    void deselectSuperior();
    void deselectEqual();
    void deselectInferior();
    
    void selectUpper();
    
    void selectNegative();
    void selectPositive();
    
    void selectSuperior();
    void selectEqual();
    void selectInferior();
    
    String getParameterText();
    void SetParameterText(String text);
    void setParamaterTextEditable();
    void setParamaterTextNotEditable();
    
    void setWindowLoading(boolean windowLoading);
    
}
