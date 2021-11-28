package com.punchcode.effective_java.chapter3;

import java.math.BigDecimal;
import java.util.*;

/**
 * Item 14: Consider implementing Comparable
 * @author huanruiz
 * @since 2021/11/26
 */
public class Item14 {

    public static void main(String[] args) {
        // String实现了Comparable
        Set<String> s = new TreeSet<>();
        String[] strings = {"b", "c", "a", "ab"};
        Collections.addAll(s, strings);
        System.out.println(s);

        // BigDecimal的equals意义与compareTo不同, equals要考虑精度
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.00");
        HashSet<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(bigDecimal1);
        hashSet.add(bigDecimal2);

        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(bigDecimal1);
        treeSet.add(bigDecimal2);

        System.out.println(hashSet);
        System.out.println(treeSet);

        // 注意越界问题, 做return的返回值要注意
        Integer integer1 = Integer.valueOf(-2000000000);
        Integer integer2 = Integer.valueOf(1000000000);
        System.out.println(integer1 - integer2);
        // 正确方式1
        System.out.println(Integer.compare(integer1, integer2));
        // 正确方式2
        Comparator<Integer> integerOrder = Comparator.comparingInt(o -> o.intValue());
        System.out.println(integerOrder.compare(integer1, integer2));
    }
}
