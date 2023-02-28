package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Harry Zhang
 * @since: 27/Feb/2023
 */
public class ReentrantLockExample {

    int a = 0;

    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock(); // 获取锁
        try {
            a++;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public void reader() {
        lock.lock(); // 获取锁
        try {
            int i = a;
            // ......
        } finally {
            lock.unlock(); // 释放锁
        }
    }
}
