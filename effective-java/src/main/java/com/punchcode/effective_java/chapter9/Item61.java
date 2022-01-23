package com.punchcode.effective_java.chapter9;

import java.util.Comparator;

/**
 * Item 61: Prefer primitive types to boxed primitives
 * @author huanruiz
 * @since 2022/1/23
 */
public class Item61 {

    public static void main(String[] args) {
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        Comparator<Integer> naturalOrder2 = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // Auto-unboxing
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        // 不能用==比较
        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));
        System.out.println(naturalOrder2.compare(new Integer(42), new Integer(42)));
    }
}
