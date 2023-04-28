package com.punchcode.the_art_of_java_concurrency_programming.chapter8.c8_2;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Harry Zhang
 * @since 2023-04-28
 */
public class CyclicBarrierTest2 {

    private static CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println(3));

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
            }
            System.out.println(1);
        }).start();

        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
}
