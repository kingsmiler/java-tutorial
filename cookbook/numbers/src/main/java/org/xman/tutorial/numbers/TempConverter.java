package org.xman.tutorial.numbers;


/* Print a table of Fahrenheit and Celsius temperatures 
 * @author Ian F. Darwin, http://www.darwinsys.com/
 */
// BEGIN main
public class TempConverter {

    public static void main(String[] args) {
        TempConverter t = new TempConverter();
        t.start();
        t.data();
        t.end();
    }

    public static double cToF(double deg) {
        return (deg * 9 / 5) + 32;
    }

    public static double fToC(double deg) {
        return (deg - 32) * (5d / 9);
    }

    protected void start() {
    }

    protected void data() {
        for (int i = -40; i <= 120; i += 10) {
            double c = fToC(i);
            print(i, c);
        }
    }

    protected void print(double f, double c) {
        System.out.println(f + " " + c);
    }

    protected void end() {
    }
}
// END main
