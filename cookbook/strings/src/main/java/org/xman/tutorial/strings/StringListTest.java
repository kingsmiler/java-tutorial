package org.xman.tutorial.strings;


import java.util.ArrayList;

public class StringListTest {

    public static void main(String[] args) {
        testStringList();
    }

    public static void testStringList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        System.out.println("list.toString()=" + list.toString());

        String message = list.toString();

        String[] items = message.split("\\[\\s*|\\s*,\\s*|\\s*]");
        System.out.println(items.length);
        for (int i = 0; i < items.length; i++) {
            System.out.println("i=" + i + "; item=" + items[i]);
        }
    }
}
