package com.punchcode.effective_java.chapter5.common;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author huanruiz
 * @since 2021/12/15
 */
public class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e) {
        ensureCapacity(); elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        // Eliminate obsolete reference return result;
        elements[size] = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
