package com.punchcode.java_concurrency_in_practice.chapter5;

import com.punchcode.java_concurrency_in_practice.chapter5.common.Computable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 相比Memoizer1, 虽然compute本身不会阻塞, 但是如果有某个消耗大量资源的运算在线程1,
 * 线程2不知道线程1正在计算, 会再次进行这个计算. 是世上最好的方式是等待线程1计算结束后直接用
 * 缓存中线程1已计算好的结果
 * @author huanruiz
 * @since 2022/2/28
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();

    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
