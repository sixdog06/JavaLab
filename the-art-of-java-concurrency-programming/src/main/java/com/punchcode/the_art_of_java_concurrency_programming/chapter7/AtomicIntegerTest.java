package com.punchcode.the_art_of_java_concurrency_programming.chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huanruiz
 * @since 2023/4/26
 */
public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(1);
    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
