package com.cvhau.javaexample;

import com.github.slugify.Slugify;
import org.apache.commons.lang3.StringUtils;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String text = "Chiều chiều ra đứng ngõ sau. Trông về quê mẹ ruột đau chín chiều.";
        String result = StringUtils.stripAccents(text);
        System.out.println(result);

//        Slugify slugify = new Slugify()
//                .withCustomReplacement("đ", "d")
//                .withCustomReplacement("Đ", "D");
        Slugify slugify = new Slugify().withTransliterator(true);
        String slugifyResult = slugify.slugify(text);
        System.out.println(slugifyResult);

        String text1 = "192.168.10.224:8080";

        String result1 = slugify.slugify(text1);
        System.out.println(result1);

        char[] dChars = new char[] {
                '\u0414', '\u0434', '\u0394', '\u03B4', '\u062F', '\u0636', '\u0111', '\u0110'
        };

        System.out.println("List of D chars:");

        for (char d : dChars) {
            System.out.println("    " + d);
        }

//        System.out.println(Integer.toHexString((int) 'đ'));
//        System.out.println(Integer.toHexString((int) 'Đ'));
    }
}
