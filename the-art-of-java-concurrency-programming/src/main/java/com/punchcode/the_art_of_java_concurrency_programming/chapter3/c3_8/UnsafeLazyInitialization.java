package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_8;

/**
 * @author: Harry Zhang
 * @since: 01/Mar/2023
 */
public class UnsafeLazyInitialization {

    private static Object instance;

    public static Object getInstance() {
        if (instance == null) {// 1: A线程执行
            instance = new Object(); // 2: B线程执行
        }
        return instance;
    }
}
