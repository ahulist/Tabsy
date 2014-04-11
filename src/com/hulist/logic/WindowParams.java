/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hulist.logic;

import com.hulist.logic.second_column.tabs.TabsColumnTypes;
import com.hulist.logic.second_column.SecondColumnFileTypes;
import java.io.File;
import com.hulist.logic.temperatures.TemperaturesFileTypes;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public class WindowParams {
    
    private boolean allYears;
    private int startYear;
    private int endYear;
    private File secondColumnFile, temperatureFile;
    private SecondColumnFileTypes secColFileType;
    private TabsColumnTypes secColumnType;
    private TemperaturesFileTypes tempFileType;

    public WindowParams() {
    }
    
    public WindowParams(boolean allYears, int startYear, int endYear, File secondColumnFile, File temperatureFile, SecondColumnFileTypes secColFileType, TabsColumnTypes secColumnType, TemperaturesFileTypes tempFileType) {
        this.allYears = allYears;
        this.startYear = startYear;
        this.endYear = endYear;
        this.secondColumnFile = secondColumnFile;
        this.temperatureFile = temperatureFile;
        this.secColFileType = secColFileType;
        this.secColumnType = secColumnType;
        this.tempFileType = tempFileType;
    }

    public boolean isAllYears() {
        return allYears;
    }

    public void setAllYears(boolean allYears) {
        this.allYears = allYears;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public File getSecondColumnFile() {
        return secondColumnFile;
    }

    public void setSecondColumnFile(File secondColumnFile) {
        this.secondColumnFile = secondColumnFile;
    }

    public File getTemperatureFile() {
        return temperatureFile;
    }

    public void setTemperatureFile(File temperatureFile) {
        this.temperatureFile = temperatureFile;
    }

    public SecondColumnFileTypes getSecColFileType() {
        return secColFileType;
    }

    public void setSecColFileType(SecondColumnFileTypes secColFileType) {
        this.secColFileType = secColFileType;
    }

    public TabsColumnTypes getSecColumnType() {
        return secColumnType;
    }

    public void setSecColumnType(TabsColumnTypes secColumnType) {
        this.secColumnType = secColumnType;
    }

    public TemperaturesFileTypes getTempFileType() {
        return tempFileType;
    }

    public void setTempFileType(TemperaturesFileTypes tempFileType) {
        this.tempFileType = tempFileType;
    }

        
    
}
