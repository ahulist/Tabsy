/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulist.logic.second_column;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public enum SecondColumnFileTypes {

    DEKADOWY("dekadowy"),
    TABS("*_tabs.txt");

    String displayName;

    private SecondColumnFileTypes(String displayName) {
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
        String[] names = new String[SecondColumnFileTypes.values().length];
        int counter = 0;
        for( SecondColumnFileTypes type : SecondColumnFileTypes.values() ) {
            names[counter] = type.getDisplayName();
            counter++;
        }
        return names;
    }

}
