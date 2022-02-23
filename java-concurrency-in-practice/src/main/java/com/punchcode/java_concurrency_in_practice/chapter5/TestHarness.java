package com.punchcode.java_concurrency_in_practice.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * @author huanruiz
 * @since 2022/2/23
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        // 初始值为1
        final CountDownLatch startGate = new CountDownLatch(1);
        // 初始值为线程数
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {

                @Override
                public void run() {
                    try {
                        // 在启动门上等待
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            // 结束门在每个线程结束后减1
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        // 启动门减1, 其他线程开始运行
        startGate.countDown();
        // 主线程等待, 其他线程全部运行结束后才回运行
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\tleave");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\tdoor close");
    }
}
