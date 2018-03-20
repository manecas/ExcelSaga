/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

/**
 *
 * @author Luis
 */
public interface IFilterPresenter {
    
    void onExitClicked();
    void onExitPressed();
    void onExitReleased();
    
    void onHeaderPressed(int x, int y);
    void onHeaderDragged(int x, int y);
    
    void onConfirmClicked();
    void onConfirmPressed();
    void onConfirmReleased();
    
    void onUpperSelected();
    void onUpperDeselected();
    
    void onPositiveSelected();
    void onPositiveDeselected();
    
    void onNegativeSelected();
    void onNegativeDeselected();
    
    void onSuperiorSelected();
    void onSuperiorDeselected();
    
    void onEqualSelected();
    void onEqualDeselected();
    
    void onInferiorSelected();
    void onInferiorDeselected();
    
}
