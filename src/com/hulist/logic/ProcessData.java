/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulist.logic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.hulist.logic.second_column.tabs.TabsDataContainer;
import com.hulist.logic.second_column.tabs.TabsImporter;
import com.hulist.logic.temperatures.icru.IcruDataContainer;
import com.hulist.logic.temperatures.icru.IcruImporter;
import java.util.concurrent.FutureTask;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public class ProcessData implements Runnable {

    WindowParams wp = null;
    Thread.UncaughtExceptionHandler handler = null;
    
    private final Logger log;

    public ProcessData(WindowParams wp) {
        this.wp = wp;
        this.log = Logger.getLogger(this.getClass().getCanonicalName());
        log.setLevel(Level.ALL);
    }

    public ProcessData(WindowParams wp, Thread.UncaughtExceptionHandler handler) {
        this(wp);
        this.handler = handler;
    }

    @Override
    public void run() {
        Logger.getLogger(this.getClass().getCanonicalName()).log(Level.FINE, "Uruchomiono przetwarzanie danych.");
        switch( wp.getSecColFileType() ) {
            case TABS:
                try {
                    processTabs();
                } catch( NullPointerException | IOException ex ) {
                    log.log(Level.SEVERE, "Błąd odczytu z pliku.");
                    log.log(Level.FINEST, ex.getMessage());
                    throw new RuntimeException(ex);
                } catch( Exception ex ){
                    log.log(Level.SEVERE, "Wystąpił nieznany błąd.");
                    log.log(Level.FINEST, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                break;
            case DEKADOWY:
                break;
        }
    }

    public void go() {
        Thread t = new Thread(this);
        if( this.handler != null ){
            // TODO dodać obsługę w klasie wywołującej
            t.setUncaughtExceptionHandler(handler);
        }
        t.start();
    }

    private void processTabs() throws IOException, NullPointerException {
        TabsImporter tabsImporter = new TabsImporter(wp.isAllYears(), wp.getStartYear(), wp.getEndYear());
        TabsDataContainer tabsCont = tabsImporter.getData(wp.getSecondColumnFile());
        
        IcruImporter icruImporter = new IcruImporter(wp.isAllYears(), wp.getStartYear(), wp.getEndYear());
        IcruDataContainer icruCont = icruImporter.getData(wp.getTemperatureFile());
        
        int yearStart = Math.max(tabsCont.getYearMin(), icruCont.getYearMin());
        int yearEnd = Math.min(tabsCont.getYearMax(), icruCont.getYearMax());
        
        PearsonsCorrelationProcessing pearsons = new PearsonsCorrelationProcessing(tabsCont, icruCont);
        pearsons.go( wp.getSecColumnType(), yearStart, yearEnd);
    }
}
