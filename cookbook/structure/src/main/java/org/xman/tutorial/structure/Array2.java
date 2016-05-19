package org.xman.tutorial.structure;

import java.util.Date;

/**
 * Re-allocate an array, bigger...
 *
 * @author Ian Darwin
 */
public class Array2 {
    public final static int INITIAL = 10;
    public final static int GROW_FACTOR = 2;

    public static void main(String[] argv) {
        int nDates = 0;
        Date[] dates = new Date[INITIAL];
        StructureDemo source = new StructureDemo(21);
        Date c;
        while ((c = (source.getDate())) != null) {

            // better: reallocate, making data structure dynamic
            if (nDates >= dates.length) {
                Date[] tmp = new Date[dates.length * GROW_FACTOR];
                System.arraycopy(dates, 0, tmp, 0, dates.length);
                dates = tmp;    // copies the array reference
                // old array will be garbage collected soon...
            }
            dates[nDates++] = c;
        }
        System.out.println("Final array size = " + dates.length);
    }
}

