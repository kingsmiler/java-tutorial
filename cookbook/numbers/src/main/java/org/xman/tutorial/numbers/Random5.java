package org.xman.tutorial.numbers;


import org.xman.io.FileIO;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Print "n" calls to nextDouble() and nextGaussian() in raw form
 * using java.util.Random.next*(); results are plotted using
 * the "R" script randomnesshistograms.r via javax.script and "renjin"
 * (err, except that renjin doesn't fully implement R graphics yet).
 */
public class Random5 {
    private static final String R_SCRIPT_FILE = "/randomnesshistograms.r";
    private static final int N = 10000;

    public static void main(String[] argv) throws Exception {
        // java.util.Random methods are non-static, do need to construct
        Random r = new Random();
        double[] us = new double[N], ns = new double[N];
        for (int i = 0; i < N; i++) {
            us[i] = r.nextDouble();
            ns[i] = r.nextGaussian();
        }
        try (InputStream is = Random5.class.getResourceAsStream(R_SCRIPT_FILE)) {
            if (is == null) {
                throw new IllegalStateException("Can't open R file ");
            }
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("Renjin");
            engine.put("us", us);
            engine.put("ns", ns);
            engine.eval(FileIO.readerToString(new InputStreamReader(is)));
        }
    }
}
