package org.xman.tutorial.env;

import org.xman.lang.GetOpt;
import org.xman.lang.GetOptDesc;

import java.util.Map;

public class GetOptParseArgsDemo {
    public static void main(String[] args) {
// BEGIN main
        GetOptDesc[] options = {
                new GetOptDesc('n', "numeric", false),
                new GetOptDesc('o', "output-file", true),
        };
        Map<String, String> optionsFound = new GetOpt(options).parseArguments(args);
        if (optionsFound.get("n") != null) {
            System.out.println("sortType = NUMERIC;");
        }
        String outputFile = null;
        if ((outputFile = optionsFound.get("o")) != null) {
            System.out.println("output file specified as " + outputFile);
        } else {
            System.out.println("Output to System.out");
        }
// END main
    }
}
