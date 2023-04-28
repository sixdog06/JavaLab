package com.punchcode.the_art_of_java_concurrency_programming.chapter8.c8_1;

import java.util.concurrent.CountDownLatch;

/**
 * 替换了JoinCountDownLatchTest中的功能,
 * @author Harry Zhang
 * @since 2023-04-28
 */
public class CountDownLatchTest {

    private static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        // 阻塞当前线程, 直到CountDownLatch的值为0
        c.await();
        System.out.println("3");
    }
}
