package com.cvhau.javaexample.javatime;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DurationParserTest {

    @Test
    void parse() {
        DurationParser parser = new DurationParser();
        Date d = parser.parse("5 minutes");
    }
}