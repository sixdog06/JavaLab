package com.punchcode.java_concurrency_in_practice.chapter5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author huanruiz
 * @since 2022/2/21
 */
public class HiddenIterator {

    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        // 这里的迭代加锁了, 线程安全
        for (int i = 0; i < 10; i++) {
            add(r.nextInt());
        }
        // 调用toString, 进行了间接的迭代操作, 线程不安全
        System.out.println("DEBUG: added ten elements to " + set);
    }
}
