/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exports;

import java.io.File;
import model.IModel;

/**
 *
 * @author Luis
 */
public class HtmExportlBuilder extends FileExportBuilder {

    public HtmExportlBuilder() {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
