/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.command;
    
import model.Model;

/**
 *
 * @author Luis
 */
public interface ICommand {
    
    public void doIt(Model model);

    public void undoIt(Model model);
    
}
