package com.punchcode.java_concurrency_in_practice.chapter2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 用原子类保证原子性
 * @author huanruiz
 * @since 2022/1/29
 */
public class AtomicTest {

    /**
     * 使用原子变量类, 保证原子性
     */
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.getAndIncrement();
    }
}
