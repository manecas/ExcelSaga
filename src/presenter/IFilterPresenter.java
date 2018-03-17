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
    
}
