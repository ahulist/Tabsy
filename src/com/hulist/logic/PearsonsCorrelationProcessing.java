/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hulist.logic;

import java.util.HashMap;
import com.hulist.logic.second_column.tabs.TabsColumnTypes;
import com.hulist.logic.second_column.tabs.TabsDataContainer;
import com.hulist.logic.temperatures.icru.IcruDataContainer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public class PearsonsCorrelationProcessing {
    
    private class Column{
        private double[] data;
        private final String name;
        /*public Column(String name, int dataSize) {
            this.data = new double[dataSize];
            this.name = name;
        }*/
        public Column(String name, double[] data){
            this.name = name;
            this.data = data;
        }
        public String getName(){
            return name;
        }
        public double[] getData(){
            return this.data;
        }
        public void setData(double[] data) {
            this.data = data;
        }
    }
    
    private final HashMap<RelevantColumns, Double> results = new HashMap<>();
    private final HashMap<RelevantColumns, Column> columns = new HashMap<>();
    private Column primaryCol;  // column being correlated to all other columns
    private final TabsDataContainer tabsData;
    private final IcruDataContainer icruData;
    private final Logger log;

    public PearsonsCorrelationProcessing(TabsDataContainer tabsData, IcruDataContainer icruData) {
        this.tabsData = tabsData;
        this.icruData = icruData;
        this.log = Logger.getLogger(this.getClass().getCanonicalName());
        log.setLevel(Level.ALL);
    }
    
    public void go(TabsColumnTypes tabsType, int yearMin, int yearMax){
        load( tabsType, yearMin, yearMax );
        
        PearsonsCorrelation c = new PearsonsCorrelation();
        Results results = new Results();
        for( RelevantColumns col : RelevantColumns.values() ) {
            double res;
            double[] arr;
            if( col.toString().endsWith("p")){
                double[] shortData = new double[primaryCol.getData().length-1];
                System.arraycopy(primaryCol.getData(), 1, shortData, 0, shortData.length);
                arr = shortData;
            }else{
                arr = primaryCol.getData();
            }
            res = c.correlation(arr, columns.get(col).getData());
            //System.out.println(col.toString()+"\t"+res);
            log.log(Level.INFO, String.format("korelacja %s\t\t%s", col.toString(), res));
            results.map.put(col, res);
        }
    }
    
    private void load(TabsColumnTypes tabsType, int yearMin, int yearMax){
        primaryCol = new Column("PRIMARY_COL", tabsData.getArray(tabsType, yearMin, yearMax));
        for( RelevantColumns column : RelevantColumns.values() ) {
            Column c = new Column(column.toString(), icruData.getArray(column, yearMin, yearMax));
            if( column.toString().endsWith("p") ){
                double[] shortData = new double[c.getData().length-1];
                System.arraycopy(c.getData(), 0, shortData, 0, shortData.length);
                c.setData(shortData);
            }
            columns.put(column ,c);
        }
        
    }
}
