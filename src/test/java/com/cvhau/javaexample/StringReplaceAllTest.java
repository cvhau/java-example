package com.cvhau.javaexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringReplaceAllTest {

    @Test
    void replaceAll() {
        String str = "abc  \t \tbef";
        String result = str.replaceAll("[ \t\n\u000B\f\r\u001C\u001D\u001E\u001F]+", " ");
        assertEquals("abc bef", result);
    }
}
