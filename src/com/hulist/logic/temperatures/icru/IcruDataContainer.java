/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulist.logic.temperatures.icru;

import java.util.HashMap;
import com.hulist.logic.FileDataContainer;
import com.hulist.logic.RelevantColumns;
import com.hulist.util.Months;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public class IcruDataContainer extends FileDataContainer {

    private final HashMap<Integer, IcruLineContainer> data = new HashMap<>();

    public double getTemp(int year, Months month) {
        return data.get(year).getTemp(month);
    }

    public IcruLineContainer getYearlyTemps(int year) {
        return data.get(year);
    }

    public void addYearlyData(int year, IcruLineContainer ilc) {
        this.data.put(year, ilc);
        if( ilc.getYear() > yearMax ){
            yearMax = ilc.getYear();
        }
        if( ilc.getYear() < yearMin ){
            yearMin = ilc.getYear();
        }
    }

    public HashMap<Integer, IcruLineContainer> getData() {
        return data;
    }

    public double[] getArray(RelevantColumns col) {
        return getArray(col, getYearMin(), getYearMax());
    }
    
    public double[] getArray(RelevantColumns col, int yearStart, int yearEnd) {
        int numOfYears = yearEnd - yearStart + 1;
        double[] arr = new double[numOfYears];
        for( int i = yearStart; i <= yearEnd; i++ ) {
            System.out.println(col.toString()+"\t"+i);
            double sum = 0;
            double dividers = 0;
            Months currMonth = col.getStart();
            int currMonthOrdinal = currMonth.ordinal();
            while( currMonthOrdinal <= col.getEnd().ordinal() ) {
                sum += this.data.get(i).getTemp(currMonth);
                currMonth = currMonth.getNext();
                currMonthOrdinal++;
                dividers++;
            }
            sum /= dividers;

            arr[i - getYearMin()] = sum;
        }
        return arr;
    }
}
