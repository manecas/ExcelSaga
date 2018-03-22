/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class Macro {

    private ArrayList<ICommand> commands;
    private boolean recordingMacro;

    public Macro() {
        this.commands = new ArrayList<>();
        this.recordingMacro = false;
    }
    
    public void addCommand(ICommand command){
        commands.add(command);
    }
    
    public void clearCommands(){
        commands.clear();
    }

    public ArrayList<ICommand> getCommands() {
        return commands;
    }

    public boolean isRecordingMacro() {
        return recordingMacro;
    }

    public void setRecordingMacro(boolean recordingMacro) {
        this.recordingMacro = recordingMacro;
    }
    
}
