package com.punchcode.java_concurrency_in_practice.chapter4;

import java.util.List;

/**
 * 防止报错, 我的例子注释了{@code implements List<T>}
 * @author huanruiz
 * @since 2022/2/16
 */
public class ImprovedList<T> { //implements List<T> {

    private final List<T> list;
    
    /**
     * 这个地方传入后, 客户端就应该停止使用list
     * @param list
     */
    public ImprovedList(List<T> list) {
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x) {
        boolean contains = list.contains(x);
        if (contains) {
            list.add(x);
        }
        return !contains;
    }

    public synchronized void clear() {
        list.clear();
    }

    // ... similarly delegate other List methods
}
