/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulist.logic.temperatures;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public enum TemperaturesFileTypes {

    ICRU("icru*.dat.txt");

    String displayName;

    private TemperaturesFileTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    /**
     * array order is consistent with FileTypes.values() order
     * @return 
     */
    public static String[] getDisplayNames(){
        String[] names = new String[TemperaturesFileTypes.values().length];
        int counter = 0;
        for( TemperaturesFileTypes type : TemperaturesFileTypes.values() ) {
            names[counter] = type.getDisplayName();
            counter++;
        }
        return names;
    }

}
