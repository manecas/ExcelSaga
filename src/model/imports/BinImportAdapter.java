/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.imports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IModel;

/**
 *
 * @author Luis
 */
public class BinImportAdapter extends FileImportAdapter {

    public BinImportAdapter(File file) {
        super(file);
    }

    @Override
    public IModel importModel() {
        ObjectInputStream ois = null;
        IModel model = null;
        
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            model = (IModel) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinImportAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BinImportAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException ex) {
                }
            }
        }
        
        return model;
    }
    
}
