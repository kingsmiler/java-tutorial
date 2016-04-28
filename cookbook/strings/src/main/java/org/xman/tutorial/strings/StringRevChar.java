package org.xman.tutorial.strings;

/**
 * Reverse a string by character
 *
 * @author Ian F. Darwin, http://www.darwinsys.com/
 */
public class StringRevChar {
    public static void main(String[] argv) {
        String sh = "FCGDAEB";
        System.out.println(sh + " -> " + new StringBuilder(sh).reverse());
    }
}
