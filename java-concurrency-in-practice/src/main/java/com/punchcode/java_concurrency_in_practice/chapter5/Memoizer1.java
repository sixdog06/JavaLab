package com.punchcode.java_concurrency_in_practice.chapter5;

import com.punchcode.java_concurrency_in_practice.chapter5.common.Computable;

import java.util.HashMap;
import java.util.Map;

/**
 * 对整个compute进行加锁, 如果单个线程的操作时间很长, 导致阻塞其他线程, 反而可能比不缓存还慢
 * @author huanruiz
 * @since 2022/2/28
 */
public class Memoizer1<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<A, V>();

    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
