package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_8;

/**
 * 错误的双重检查锁
 * @author: Harry Zhang
 * @since: 01/Mar/2023
 */
public class DoubleCheckedLocking { // 1

    private static Object instance; // 2

    public static Object getInstance() { // 3
        if (instance == null) { // 4:第一次检查
            synchronized (DoubleCheckedLocking.class) { // 5: 加锁
                if (instance == null) { // 6: 第二次检查
                    instance = new Object(); // 7: 问题的根源出在这里
                }
            } // 8
        } // 9
        return instance; // 10
    } // 11
}
