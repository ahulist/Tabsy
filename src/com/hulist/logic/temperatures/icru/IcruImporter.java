/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulist.logic.temperatures.icru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import com.hulist.logic.BaseImporter;
import com.hulist.logic.DataImporter;
import com.hulist.util.Months;
import java.util.logging.Level;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public class IcruImporter extends BaseImporter implements DataImporter<IcruDataContainer> {

    public static final double VALUE_MAX = 200.0;
    public static final double VALUE_MIN = -200.0;

    public IcruImporter(boolean isAllYears, int startYear, int endYear) {
        super(isAllYears, startYear, endYear);
    }

    @Override
    public IcruDataContainer getData(File f) throws FileNotFoundException, IOException {
        InputStream fis;
        BufferedReader br;
        String line;
        IcruDataContainer container = new IcruDataContainer();

        fis = new FileInputStream(f);
        br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
        int lineCounter = 1;
        while( (line = br.readLine()) != null ) {
            if( lineCounter > 4 ){
                String[] data = line.trim().split("[\\s\\t]+");
                try {
                    if( allYears
                            || (!allYears
                            && Integer.parseInt(data[0]) >= startYear
                            && Integer.parseInt(data[0]) <= endYear) ){

                        assert data.length == 13;
                        int year = Integer.parseInt(data[0]);
                        IcruLineContainer lineData = new IcruLineContainer(year);
                        int counter = 1;
                        for( Months month : Months.values() ) {
                            double value = Double.parseDouble(data[counter]);
                            if( value < VALUE_MIN || value > VALUE_MAX ){
                                StringBuilder sb = new StringBuilder();
                                if( value < VALUE_MIN ){
                                    sb.append("Odczytana wartość < ").append(VALUE_MIN);
                                }
                                if( value > VALUE_MAX ){
                                    sb.append("Odczytana wartość > ").append(VALUE_MAX);
                                }
                                sb.append(", w pliku ").append(f.getCanonicalPath()).append(" dla roku ").append(year).append(", dla miesiąca ").append(month);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            lineData.addMonthlyData(month, value);
                            counter++;
                        }
                        container.addYearlyData(year, lineData);
                    }
                } catch( AssertionError | IOException | NumberFormatException e ) {
                    log.log(Level.WARNING, String.format("Nieprawid\u0142owy format pliku %s.", f.getName()));
                    throw new RuntimeException();
                } catch( IllegalArgumentException e ) {
                    log.log(Level.WARNING, e.getMessage());
                    throw new RuntimeException();
                } 

            }
            lineCounter++;
        }

        br.close();

        return container;
    }

}
