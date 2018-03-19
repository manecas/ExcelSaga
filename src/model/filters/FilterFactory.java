/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.filters;

import model.Cell;

/**
 *
 * @author Luis
 */
public class FilterFactory {
    
    private FilterFactory() {
    }
    
    public static Cell getFilter(String filterType, double x, Cell cell){
        switch(filterType){
            case Filter.UPPER: return new UpperFilterDecotator(cell);
            case Filter.INFERIOR: return new InferiorFilterDecorator(cell, x);
            case Filter.EQUAL: return new EqualFilterDecorator(cell, x);
            case Filter.SUPERIOR: return new SuperiorFilterDecotator(cell, x);
            c
        }
        
        return null;
    }
    
}
