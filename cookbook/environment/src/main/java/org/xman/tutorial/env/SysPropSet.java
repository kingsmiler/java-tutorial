package org.xman.tutorial.env;

import java.util.Properties;

/**
 * Try adding one or more item(s) to class path.
 */
public class SysPropSet {

    static Properties p = System.getProperties();

    public static void main(String[] argv) {
        String javaHome = System.getenv("JAVA_HOME");
        String pathSeparator = System.getProperty("path.separator");
        System.out.println("System Properties:");
        System.out.println("java.class.path now = " + getClassPath());
        p.setProperty("java.class.path",
                getClassPath() + pathSeparator + javaHome +"/lib/tools.jar");

        System.out.println("java.class.path now = " + getClassPath());
        try {
            // JavaP is in the tools.jar
            Class.forName("sun.tools.javap.JavaP");
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
        System.out.println("Got it!!");
    }

    static String getClassPath() {
        return p.getProperty("java.class.path", null);
    }
}
