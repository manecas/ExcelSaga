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
    
    public static Filter getFilter(String filterType){
        switch(filterType){ 
            case Filter.UPPER: return new UpperFilterDecotator(Filter.UPPER);
            case Filter.INFERIOR: return new InferiorFilterDecorator(Filter.INFERIOR);
            case Filter.EQUAL: return new EqualFilterDecorator(Filter.EQUAL);
            case Filter.SUPERIOR: return new SuperiorFilterDecotator(Filter.SUPERIOR);
            case Filter.POSITIVE: return new PositiveFilterDecotator(Filter.POSITIVE);
            case Filter.NEGATIVE: return new NegativeFilterDecorator(Filter.NEGATIVE);
        }
        
        return null;
    }
    
}
