/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ExcelSagaModel;
import view.ExcelSagaView;

/**
 *
 * @author Luis
 */
public class ExcelSagaController {

    private ExcelSagaView view;
    private ExcelSagaModel model;
    
    public ExcelSagaController(ExcelSagaView view, ExcelSagaModel model) {
        this.view = view;
        this.model = model;
    }
    
}
