package com.cvhau.javaexample;

import org.junit.jupiter.api.Test;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void appTest() {
        assertTrue(true);
    }

    @Test
    public void urlDecode() {
        String encodedStr = "%3c%61%20%68%72%65%66%3d%22%68%74%74%70%3a%2f%2f%77%77%77%2e%66%72%65%65%70%72%6f%78%79%6c%69%73%74%73%2e%6e%65%74%2f%33%34%2e%38%34%2e%31%38%30%2e%34%33%2e%68%74%6d%6c%22%3e%33%34%2e%38%34%2e%31%38%30%2e%34%33%3c%2f%61%3e";
        String decodedStr = URLDecoder.decode(encodedStr, StandardCharsets.UTF_8);
        System.out.println(encodedStr);
        System.out.println(decodedStr);
    }
}