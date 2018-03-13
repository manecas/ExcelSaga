/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.doundo;

import java.util.ArrayList;
import java.util.List;
import model.Model;

/**
 *
 * @author Luis
 */
public class CommandManager {
    
    private List<ICommand> undoList;
    private List<ICommand> redoList;
    private Model model;

    public CommandManager(Model model) {
        undoList = new ArrayList<>();
        redoList = new ArrayList<>();
        this.model = model;
    }
    
    //do
    public void apply(ICommand command){
        
        command.doIt(model);
        undoList.add(command);
        redoList.clear();
        
    }
    
    public void undo(){
        
        if(undoList.isEmpty()){
            return;
        }
        
        int lastCommandIndex = undoList.size() - 1;
        
        ICommand lastCommand = undoList.remove(lastCommandIndex);
        lastCommand.undoIt(model);
        redoList.add(lastCommand);
        
    }
    
    public void redo(){
        
        if(redoList.isEmpty()){
            return;
        }
        
        int lastCommandIndex = redoList.size() - 1;
        
        ICommand lastCommand = redoList.remove(lastCommandIndex);
        lastCommand.doIt(model);
        undoList.add(lastCommand);
        
        
    }
    
}
