/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.



Implement the following interface, and create a test suite with 100% test coverage for your
newly implemented class. Following the java documentation provided on the interface as
guidance to the outcome of each unit.

 */
package com.mycompany.project3;

/**
 *
 * @author Rüdiger
 */
public interface CaseUtil {
   /**
* Accepts Strings and converts it to Camel Case.
*
* Input: Hello World
* Output: Hello World
*
* Input: I love java
* Output: iLoveJava
**/
String asCamelCase(String text);
/**
* Accepts Strings and converts it to Snake Case.
*
* Input: Hello World
* Output: hello_world
*
* Input: I love java
* Output: i_love_java
**/
String asSnakeCase(String text);
/**
* Accepts Strings and converts it to Human Readable Text.
*
* Input: hello_world
* Output: Hello world.
*
* Input: i LOVE java 
* *Output: I love java.
**/ 
String ashumanReadableText(String Text);
}
