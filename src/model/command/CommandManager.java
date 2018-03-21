/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.IModel;

/**
 *
 * @author Luis
 */
public class CommandManager implements Serializable {
    
    private ArrayList<ICommand> undoList;
    private ArrayList<ICommand> redoList;
    private IModel model;

    public CommandManager(IModel model) {
        undoList = new ArrayList<>();
        redoList = new ArrayList<>();
        this.model = model;
    }
    
    public void apply(ArrayList<ICommand> commands){
        for (ICommand command : commands) {
            command.doIt(model);
            undoList.add(command);
        }
        redoList.clear();
    }
    
    public void apply(ICommand command){
        command.doIt(model);
        undoList.add(command);
        redoList.clear();
    }
    
    public void undo(){
        if(undoList.isEmpty()){
            System.out.println("Undo is empty...");
            return;
        }
        
        int lastCommandIndex = undoList.size() - 1;
        
        ICommand lastCommand = undoList.remove(lastCommandIndex);
        lastCommand.undoIt(model);
        redoList.add(lastCommand);
    }
    
    public void redo(){
        if(redoList.isEmpty()){
            System.out.println("Redo is empty...");
            return;
        }
        
        int lastCommandIndex = redoList.size() - 1;
        
        ICommand lastCommand = redoList.remove(lastCommandIndex);
        lastCommand.doIt(model);
        undoList.add(lastCommand);
    }
    
}
