package com.punchcode.effective_java.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 26: Don’t use raw types
 * @author huanruiz
 * @since 2021/12/13
 */
public class Item26 {

    public static void main(String[] args) {
        List<String> strings1 = new ArrayList<>();
        unsafeAdd(strings1, Integer.valueOf(42));

        // java.lang.Integer cannot be cast to java.lang.String
//        String s1 = strings1.get(0);

        List<String> strings2 = new ArrayList<>();
        // 编译期报错
//        safeAdd(strings2, Integer.valueOf(42));
    }

    /**
     * 这里的list没有泛型, unsafe
     */
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }
}
