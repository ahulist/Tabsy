/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hulist.logic;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public abstract class FileDataContainer {

    protected int yearMin = Integer.MAX_VALUE, yearMax = Integer.MIN_VALUE;
    
    public int getYearMin() {
        return yearMin;
    }

    public int getYearMax() {
        return yearMax;
    }
}
