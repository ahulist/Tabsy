/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hulist.util;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public enum Months {
    // do NOT change the order!
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;
    
    public Months getNext(){
        return values()[ (ordinal()+1) % values().length ];
    }
}
