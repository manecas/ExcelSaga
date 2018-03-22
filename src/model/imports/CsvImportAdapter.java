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
public class CsvImportAdapter extends FileImportAdapter {

    public CsvImportAdapter(File file) {
        super(file);
    }
    
    @Override
    public IModel importModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
