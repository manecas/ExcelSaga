/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IModel;

/**
 *
 * @author Luis
 */
public class BinExportBuilder extends FileExportBuilder {

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
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(model);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinExportBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinExportBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException ex) {
                }
            }
        }
        
    }
    
}
