/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rüdiger
 */
public class CaseUtilClass implements CaseUtil {

    /**
     * Accepts Strings and converts it to Human Readable Text.
     *
     * Input: hello_world Output: Hello world.
     *
     * Input: i LOVE java Output: I love java.
     *
     */
    public String ashumanReadableText(String text) {

        String outputText = text.trim();

        if (text.contains("_")) {
            outputText = String.join(" ", outputText.split("_"));
        } 

        outputText = String.valueOf(outputText.charAt(0)).toUpperCase() + outputText.toLowerCase().substring(1) + ".";

        return outputText;
    }

/**
* Accepts Strings and converts it to Camel Case.
*
* Input: Hello World
* Output: helloWorld
*
* Input: I love java
* Output: iLoveJava
**/
    
    public String asCamelCase(String text) {
        String outputText = text.trim();
        String[] arr = {};

        if (text.contains(" ")) {
            arr = outputText.split(" ");
        }
        else if (text.contains("_")) {
            arr = outputText.split("_");
        }
        
        for(int i = 0; i < arr.length;i++) {
            if(i == 0){
                outputText = arr[i].toLowerCase();  
            } else {
                if(arr[i].length() > 1){
                    outputText += String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].toLowerCase().substring(1);
                }
                else {
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

}
