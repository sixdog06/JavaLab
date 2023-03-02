package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_8;

/**
 * @author: Harry Zhang
 * @since: 01/Mar/2023
 */
public class SafeLazyInitialization {

    private static Object instance;

    public synchronized static Object getInstance() {
        if (instance == null) {
            instance = new Object();
        }
        return instance;
    }
}
