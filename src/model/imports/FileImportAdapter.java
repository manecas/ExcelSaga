/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.imports;

import java.io.File;
import model.IModel;

/**
 *
 * @author Luis
 */
public abstract class FileImportAdapter {
    
    protected File file;

    public FileImportAdapter(File file) {
        this.file = file;
    }
    
    public abstract IModel importModel();
    
}
