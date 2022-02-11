package com.punchcode.java_concurrency_in_practice.chapter4;

/**
 * 监视器模式的线程安全计数器
 * @author huanruiz
 * @since 2022/2/11
 */
public final class Counter {

    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
