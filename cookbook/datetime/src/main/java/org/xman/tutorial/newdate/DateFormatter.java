package org.xman.tutorial.newdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static void main(String[] args) {

        // Format a date ISO8601-like but with slashes instead of dashes
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(df.format(LocalDate.now()));

        // Parse a String to a date using the same formatter
        System.out.println(LocalDate.parse("2014-09-01", df));

        // Format a Date and Time without timezone information
        DateTimeFormatter nTZ =
                DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
        System.out.println(ZonedDateTime.now().format(nTZ));

        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        System.out.println(df2.format(LocalDateTime.now()));
    }
}