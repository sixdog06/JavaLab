package com.punchcode.effective_java.chapter5;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Item 30: Favor generic methods todo: 没有特别理解recursive type bound这个场景
 * @author huanruiz
 * @since 2021/12/16
 */
public class Item30 {

    public static void main(String[] args) {
        /**
         * 泛型方法
         */
        Set<String> guys = new HashSet<>(Arrays.asList("Tom", "Dick", "Harry"));
        Set<String> stooges = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
        Set<String> aflCio1 = badUnion(guys, stooges);
        Set<String> aflCio2 = goodUnion(guys, stooges);

        System.out.println(aflCio1);
        System.out.println(aflCio2);

        /**
         * 泛型单例工厂
         */
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }

    /**
     * 各种warning
     */
    public static Set badUnion(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    public static <E> Set<E> goodUnion(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * Generic singleton factory pattern, 输入什么就返回什么
     */
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    /**
     * Returns max value in a collection - uses recursive type bound
     * {@code <E extends Comparable<E>>}: any type E that can be compared to itself
     */
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        // list为空, 抛错. 但是最好用Optional<E>替代
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }
}
