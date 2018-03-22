/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cell;
import model.IModel;
import model.filters.Filter;

/**
 *
 * @author Luis
 */
public class TextExportBuilder extends FileExportBuilder {

    public TextExportBuilder() {
    }

    @Override
    public FileExportBuilder setFile(File file) {
        this.file = file;
        return this;
    }

    @Override
    public FileExportBuilder setModel(IModel model) {
        this.model = model;
        return this;
    }

    @Override
    public void exportModel() {
        BufferedWriter writer = null;
        
        try {
            writer = new BufferedWriter(new FileWriter(file));
            
            Filter [][]sheet = model.getSheet();
            
            for (int i = 0; i < model.getTableModel().getRowCount(); i++) {
                for (int j = 0; j < model.getTableModel().getColumnCount(); j++) {
                    writer.write(sheet[i][j].getValue() + " ");
                }
                writer.newLine();
            }
            
            writer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(TextExportBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
