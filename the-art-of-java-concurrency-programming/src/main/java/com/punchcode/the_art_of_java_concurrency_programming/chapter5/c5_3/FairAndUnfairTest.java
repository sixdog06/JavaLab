package com.punchcode.the_art_of_java_concurrency_programming.chapter5.c5_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huanruiz
 * @since 2023/4/3
 */
public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    public static void main(String[] args) throws InterruptedException {
        FairAndUnfairTest test = new FairAndUnfairTest();
        // 按aqs中的顺序获取锁, 一个线程不会连续获得锁
        test.fair();
        // 一个线程可能连续获得锁, 造成饥饿
        test.unfair();
    }

    public void fair() throws InterruptedException {
        System.out.println("fair");
        testLock(fairLock);
    }

    public void unfair() throws InterruptedException {
        System.out.println("unfair");
        testLock(unfairLock);
    }

    private void testLock(Lock lock) throws InterruptedException {
        // 启动5个Job
        for (int i = 0; i < 5; i++) {
            Thread thread = new Job(lock) {
                @Override
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        Thread.sleep(2000);
    }

    private static class Job extends Thread {

        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            // 每个线程尝试2次获取锁
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    Thread.sleep(100);
                    System.out.println("current thread[" + Thread.currentThread().getName() + "], aqs thread" + ((ReentrantLock2) lock).getQueuedThreads() + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {

        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
