package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_8;

/**
 * @author: Harry Zhang
 * @since: 02/Mar/2023
 */
public class SafeDoubleCheckedLocking {

    private volatile static Object instance;

    public static Object getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Object(); // instance为volatile, 现在没问题了
                }
            }
        }
        return instance;
    }
}
