package com.punchcode.java_concurrency_in_practice.chapter4;

/**
 * 监视器模式的线程安全计数器
 * synchronization policy defines how an object coordinates access to its state without
 * violating its invariants or postconditions. It specifies the combination of immutability,
 * thread confinement, and locking.
 * @author huanruiz
 * @since 2022/2/11
 */
public final class Counter {

    /**
     * long是primitive type, 所以value是构成这个对象的所有状态
     */
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
