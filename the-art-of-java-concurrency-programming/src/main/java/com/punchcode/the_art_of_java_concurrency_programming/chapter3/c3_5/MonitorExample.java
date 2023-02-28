package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_5;

/**
 * @author: Harry Zhang
 * @since: 27/Feb/2023
 */
public class MonitorExample {

    int a = 0;

    public synchronized void writer() { // 1
        a++; // 2
    } // 3
    public synchronized void reader() { // 4
        int i = a; // 5
        // ......
    } // 6
}
