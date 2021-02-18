/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rüdiger
 */
public class CaseUtilTest {

    public CaseUtilTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of asCamelCase method, of class CaseUtil.
     */
    @Test
    public void testAsCamelCase() {
        System.out.println("asCamelCase");
        String text = "I love java";
        CaseUtil instance = new CaseUtilImpl();
        String expResult = "iLoveJava";
        String result = instance.asCamelCase(text);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of asSnakeCase method, of class CaseUtil.
     */
    @Test
    public void testAsSnakeCase() {
        System.out.println("asSnakeCase");
        String text = "I love java";
        CaseUtil instance = new CaseUtilImpl();
        String expResult = "i_love_java";
        String result = instance.asSnakeCase(text);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of ashumanReadableText method, of class CaseUtil.
     */
    @Test
    public void testAshumanReadableText() {
        System.out.println("ashumanReadableText");
        String Text = "i Love Java ";
        CaseUtil instance = new CaseUtilImpl();
        String expResult = "I love java.";
        String result = instance.ashumanReadableText(Text);
        assertTrue(expResult.equals(result));                
    }

    public class CaseUtilImpl implements CaseUtil {

        public String asCamelCase(String text) {
            String outputText = text.trim();
            String[] arr = {};

            if (text.contains(" ")) {
                arr = outputText.split(" ");
            } else if (text.contains("_")) {
                arr = outputText.split("_");
            }

            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    outputText = arr[i].toLowerCase();
                } else {
                    if (arr[i].length() > 1) {
                        outputText += String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].toLowerCase().substring(1);
                    } else {
                        outputText += arr[i].toUpperCase();
                    }
                }
            }
            return outputText;
        }

        public String asSnakeCase(String text) {
            String outputText = text.trim();
            Pattern pattern = Pattern.compile("[A-Z]");
            Matcher matcher = pattern.matcher(outputText);

            if (text.contains(" ")) {
                outputText = String.join("_", outputText.split(" "));
            } else if (matcher.find()) {
                outputText = String.join("_", outputText.split("(?=[A-Z])"));
            }

            return outputText.toLowerCase();
        }

        public String ashumanReadableText(String Text) {
            String outputText = Text.trim();

            if (Text.contains("_")) {
                outputText = String.join(" ", outputText.split("_"));
            }

            outputText = String.valueOf(outputText.charAt(0)).toUpperCase() + outputText.toLowerCase().substring(1) + ".";

            return outputText;
        }
    }

}
