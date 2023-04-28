package com.punchcode.the_art_of_java_concurrency_programming.chapter8.c8_1;

/**
 * @author Harry Zhang
 * @since 2023-04-28
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(() -> {});
        Thread parser2 = new Thread(() -> {System.out.println("parser2 finish"); });
        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all parser finish");
    }
}
