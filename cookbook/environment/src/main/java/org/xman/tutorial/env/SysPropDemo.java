package org.xman.tutorial.env;

import java.io.IOException;

/**
 * List one or more item(s) from System Properties
 */
public class SysPropDemo {
    public static void main(String[] argv) throws IOException {
        if (argv.length == 0)
            System.getProperties().list(System.out);
        else {
            for (String s : argv) {
                System.out.println(s + " = " + System.getProperty(s));
            }
        }
    }
}
