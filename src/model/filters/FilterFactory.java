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
    
    public static Filter getFilter(String filterType, double x, Filter nextCell){
        switch(filterType){ 
            case Filter.UPPER: return new UpperFilterDecotator(nextCell);
            case Filter.INFERIOR: return new InferiorFilterDecorator(nextCell, x);
            case Filter.EQUAL: return new EqualFilterDecorator(nextCell, x);
            case Filter.SUPERIOR: return new SuperiorFilterDecotator(nextCell, x);
            case Filter.POSITIVE: return new PositiveFilterDecotator(nextCell);
            case Filter.NEGATIVE: return new NegativeFilterDecorator(nextCell);
        }
        
        return null;
    }
    
}
