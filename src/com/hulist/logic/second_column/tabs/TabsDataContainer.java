/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulist.logic.second_column.tabs;

import java.util.HashMap;
import com.hulist.logic.FileDataContainer;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public class TabsDataContainer extends FileDataContainer {

    /**
     * key (Integer) is a year
     */
    private final HashMap<Integer, TabsLineContainer> data = new HashMap<>();

    public TabsLineContainer getLine(int year) {
        return data.get(year);
    }

    public void addLine(int year, int num, double seg, double age, double raw, double std, double res, double ars) {
        addLine(new TabsLineContainer(year, num, seg, age, raw, std, res, ars));
    }

    public void addLine(TabsLineContainer line) {
        data.put(line.getYear(), line);
        if( line.getYear() > yearMax ){
            yearMax = line.getYear();
        }
        if( line.getYear() < yearMin ){
            yearMin = line.getYear();
        }
    }

    /**
     * hashmap key is the year
     *
     * @return
     */
    public HashMap<Integer, TabsLineContainer> getData() {
        return this.data;
    }

    public double[] getArray(TabsColumnTypes type) {
        return getArray(type, getYearMin(), getYearMax());
    }

    public double[] getArray(TabsColumnTypes type, int yearStart, int yearEnd) {
        double[] arr = new double[yearEnd - yearStart + 1];
        for( int i = yearStart; i <= yearEnd; i++ ) {
            switch( type ) {
                case STD:
                    arr[i - yearStart] = data.get(i).getStd();
                    break;
                case RES:
                    arr[i - yearStart] = data.get(i).getRes();
                    break;
            }
        }
        return arr;
    }
}
