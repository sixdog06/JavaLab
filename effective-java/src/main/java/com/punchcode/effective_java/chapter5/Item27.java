package com.punchcode.effective_java.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 27: Eliminate unchecked warnings
 * @author huanruiz
 * @since 2021/12/14
 */
public class Item27 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        /**
         * 下面的@SuppressWarnings("unchecked")实际上可以加到return语句上, 防止unchecked cast warning
         * {@code return (T[]) Arrays.copyOf(elementData, size, a.getClass())}
         */
        list.toArray(new Integer[]{2, 3});
        System.out.println(list);
    }
}
