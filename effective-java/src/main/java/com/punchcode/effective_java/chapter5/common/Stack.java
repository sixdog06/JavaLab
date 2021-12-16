package com.punchcode.effective_java.chapter5.common;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 把非泛型的Stack改造成泛型类
 * @author huanruiz
 * @since 2021/12/15
 */
public class Stack<E> {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * step1. 换Object为E, 数组这里会报错, we can’t create an array of a non-reifiable type
     * The elements array will contain only E instances from push(E).
     * This is sufficient to ensure type safety, but the runtime
     * type of the array won't be E[]; it will always be Object[]!
     */
//    @SuppressWarnings("unchecked")
//    public Stack() {
//        //elements = new E[DEFAULT_INITIAL_CAPACITY];
//        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
//    }

    /**
     * step1 way2: elements声明为Object数组, 但是{@code public E pop()}报错
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        //elements = new E[DEFAULT_INITIAL_CAPACITY];
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * step2: elements声明为Object数组, 但是{@code public E pop()}报错, 做强制类型转换并抑制warning
     */
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E result = (E)elements[--size];

        // Eliminate obsolete reference
        elements[size] = null;
        return result;
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
