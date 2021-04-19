package com.cvhau.javaexample.javatime;

import java.time.Duration;
import java.util.Date;

public class DurationParser {

    public Date parse(String text) {

        Duration duration = Duration.parse(text);
        System.out.println(duration);

        return null;
    }
}
