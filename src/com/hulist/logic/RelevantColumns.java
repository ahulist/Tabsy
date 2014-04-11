/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hulist.logic;

import com.hulist.util.Months;

/**
 * This enum represents names of the data columns. These columns are to be correlated to some other serie of data
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public enum RelevantColumns {
    I(Months.JAN, Months.JAN),
    II(Months.FEB, Months.FEB),
    III(Months.MAR, Months.MAR),
    IV(Months.APR, Months.APR),
    V(Months.MAY, Months.MAY),
    VI(Months.JUN, Months.JUN),
    VII(Months.JUL, Months.JUL),
    VIII(Months.AUG, Months.AUG),
    IX(Months.SEP, Months.SEP),
    X(Months.OCT, Months.OCT),
    XI(Months.NOV, Months.NOV),
    XII(Months.DEC, Months.DEC),
    Ip(Months.JAN, Months.JAN),
    IIp(Months.FEB, Months.FEB),
    IIIp(Months.MAR, Months.MAR),
    IVp(Months.APR, Months.APR),
    Vp(Months.MAY, Months.MAY),
    VIp(Months.JUN, Months.JUN),
    VIIp(Months.JUL, Months.JUL),
    VIIIp(Months.AUG, Months.AUG),
    IXp(Months.SEP, Months.SEP),
    Xp(Months.OCT, Months.OCT),
    XIp(Months.NOV, Months.NOV),
    XIIp(Months.DEC, Months.DEC),
    I_III(Months.JAN, Months.MAR),
    IV_V(Months.APR, Months.MAY),
    VI_VII(Months.JUN, Months.JUL),
    VI_VIII(Months.JUN, Months.AUG),
    IX_X(Months.SEP, Months.OCT),
    XI_XII(Months.NOV, Months.DEC),
    IV_IX(Months.APR, Months.SEP),
    YEAR(Months.JAN, Months.DEC);
    
    private final Months start, end;

    private RelevantColumns(Months start, Months end) {
        this.start = start;
        this.end = end;
    }

    public Months getStart() {
        return start;
    }

    public Months getEnd() {
        return end;
    }
    
}
