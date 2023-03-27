package com.punchcode.the_art_of_java_concurrency_programming.chapter4.c4_4;

/**
 * @author: Harry Zhang
 * @since: 27/Mar/2023
 */
public class ConnectionPoolBasicTest {

    private Object result = null;

    public synchronized Object get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        // 还未超时继续等待
        while ((result == null) && remaining > 0) {
            wait(remaining);
            remaining = future - System.currentTimeMillis();
        }
        return result;
    }
}
