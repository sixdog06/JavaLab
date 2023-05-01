package com.punchcode.the_art_of_java_concurrency_programming.chapter8.c8_2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huanruiz
 * @since 2023/5/1
 */
public class CyclicBarrierTest3 {

    private static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Thread thread = new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            // 判断是否中断
            System.out.println(c.isBroken());
        }
    }
}
