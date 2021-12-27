package com.punchcode.effective_java.chapter5;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Item 32: Combine generics and varargs judiciously
 * @author huanruiz
 * @since 2021/12/23
 */
public class Item32 {

    public static void main(String[] args) {
        // 报错, toArray会以Object[]来保证最大限度接受数据, 但是传入的是String[],
        // Object[] is not a subtype of String[], 编译期并不知道传入的参数是什么
//        String[] attributes = pickTwo("Good", "Fast", "Cheap");
    }

    /**
     * 混用泛型和可变参数
     */
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = Arrays.asList(42);
        Object[] objects = stringLists;
        // Heap pollution
        objects[0] = intList;
        // ClassCastException
        String s = stringLists[0].get(0);
    }

    /**
     * Heap pollution
     */
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
            default: break;
        }
        // Can't get here
        throw new AssertionError();
    }

}
