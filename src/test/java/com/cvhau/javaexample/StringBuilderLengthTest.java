package com.cvhau.javaexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringBuilderLengthTest {
    @Test
    void countLength() {
        StringBuilder str = new StringBuilder(32);
        str.append("123456");
        assertEquals(6, str.length());
    }

    @Test
    void zeroLength() {
        StringBuilder str = new StringBuilder(32);
        assertEquals(0, str.length());
    }
}
