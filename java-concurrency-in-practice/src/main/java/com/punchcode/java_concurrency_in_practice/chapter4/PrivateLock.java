package com.punchcode.java_concurrency_in_practice.chapter4;

import com.punchcode.java_concurrency_in_practice.chapter2.Widget;

/**
 * Guarding state with a private lock. 私有锁相当于封装起来了.
 * @author huanruiz
 * @since 2022/2/14
 */
public class PrivateLock {

    private final Object myLock = new Object();

    Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget...
        }
    }
}
