/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hulist.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 * @param <K>
 */
public interface DataImporter<K extends FileDataContainer> {
    
    public K getData(File f) throws FileNotFoundException, IOException;
    
}
