package com.punchcode.effectivejava.chapter2;

import java.util.*;

/**
 * Item 7: Eliminate obsolete object references
 * @author huanruiz
 * @since 2021/11/12
 */
public class Item7 {

    public static void main(String[] args) {
        new Stack();

        // 自动淘汰entry
        new WeakHashMap<>();

        // 有removeEldestEntry, 在afterNodeInsertion(evict)中调用
        new LinkedHashMap<>();
    }
}

class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
//        elements[size] = null; // Eliminate obsolete reference
        // size减少但是依然被引用, 内存泄漏
        return elements[--size];
    }
    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}