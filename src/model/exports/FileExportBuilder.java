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
public abstract class FileExportBuilder {
    
    public static final String EXPORT_TEXT = "TEXT";
    public static final String EXPORT_CSV = "CSV";
    public static final String EXPORT_HTML = "HTML";
    public static final String EXPORT_BIN = "BIN";
     
    protected File file;
    protected IModel model;
    
    public static FileExportBuilder getBuilder(String type) {
        switch(type){
            case EXPORT_TEXT: return new TextExportBuilder();
            case EXPORT_CSV: return new CsvExportBuilder();
            case EXPORT_HTML: return new HtmExportlBuilder();
            case EXPORT_BIN: return new BinExportBuilder();
        }
        
        return null;
    }
        
    public abstract FileExportBuilder setFile(File file);
    public abstract FileExportBuilder setModel(IModel model);
    public abstract void exportModel();
    
}
