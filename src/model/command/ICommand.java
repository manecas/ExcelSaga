/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.command;
    
import java.io.Serializable;
import model.IModel;

/**
 *
 * @author Luis
 */
public interface ICommand extends Serializable {
    
    public void doIt(IModel model);

    public void undoIt(IModel model);
    
}
