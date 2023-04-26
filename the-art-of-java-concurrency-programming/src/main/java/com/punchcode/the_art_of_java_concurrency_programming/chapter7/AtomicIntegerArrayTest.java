package com.punchcode.the_art_of_java_concurrency_programming.chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author huanruiz
 * @since 2023/4/27
 */
public class AtomicIntegerArrayTest {

    public static void main(String[] args) {
        int[] value = new int[]{1, 2};
        AtomicIntegerArray ai = new AtomicIntegerArray(value);
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
