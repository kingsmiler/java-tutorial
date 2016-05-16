package org.xman.tutorial.structure;

/**
 * Simple demo to print all the types of an enum.
 */
// BEGIN main
public class EnumList {
    public static void main(String[] args) {
        for (State i : State.values()) {
            System.out.println(i);
        }
    }

    enum State {
        ON, OFF, UNKNOWN
    }
}
// END main
