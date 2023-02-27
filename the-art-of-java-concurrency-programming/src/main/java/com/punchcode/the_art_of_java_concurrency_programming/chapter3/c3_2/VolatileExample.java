package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_2;

/**
 * @author: Harry Zhang
 * @since: 27/Feb/2023
 */
public class VolatileExample {

    int a = 0;

    volatile boolean flag = false;

    public void writer() {
        a = 1; // 1
        flag = true; // 2
    }

    public void reader() {
        if (flag) { // 3
            int i = a; // 4
        }
    }
}
