package com.punchcode.the_art_of_java_concurrency_programming.chapter8.c8_4;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huanruiz
 * @since 2023/5/1
 */
public class ExchangerTest {

    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                String A = "Statement A"; // A录入银行流水数据
                exchanger.exchange(A);
            } catch (InterruptedException e) {
            }
        });

        threadPool.execute(() -> {
            try {
                String B = "Statement B";
                String A = exchanger.exchange("B");
                System.out.println("A和B数据是否一致:" + A.equals(B));
                System.out.println("A录入的是:" + A + ", B 录入的是:" + B);
            } catch (InterruptedException e) {
            }
        });
        threadPool.shutdown();
    }
}
