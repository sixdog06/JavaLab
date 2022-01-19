package com.punchcode.effective_java.chapter8;

import java.util.*;

/**
 * Item 55: Return optionals judiciously
 * @author huanruiz
 * @since 2022/1/19
 */
public class Item55 {

    public static void main(String[] args) {
        // 对比
        System.out.println("max1: " + max(Arrays.asList(1, 2, 3)));
        System.out.println("max2: " + max2(Arrays.asList(1, 2, 3)));
        System.out.println("max2: " + max2(new ArrayList<Integer>()));
        System.out.println("max3: " + max3(Arrays.asList(1, 2, 3)));
        System.out.println("max3: " + max3(new ArrayList<Integer>()));

        /**
         * optional的使用
         */
        System.out.println("max3: " + max3(new ArrayList<Integer>()).orElse(233));
        System.out.println("max3: " + max3(Arrays.asList(1, 2, 3)).get());
    }

    public static <E extends Comparable<E>> E max(Collection<E> c) {
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

    /**
     * Returns maximum value in collection as an Optional<E>
     */
    public static <E extends Comparable<E>> Optional<E> max2(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return Optional.of(result);
    }

    /**
     * Returns max val in collection as Optional<E> - uses stream
     */
    public static <E extends Comparable<E>> Optional<E> max3(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }
}
