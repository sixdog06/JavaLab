package com.punchcode.effective_java.chapter8;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Item 52: Use overloading judiciously
 * @author huanruiz
 * @since 2022/1/18
 */
public class Item52 {

    public static void main(String[] args) {
        // 错
        Collection<?>[] collections = {new HashSet<String>(), new ArrayList<BigInteger>(), new HashMap<String, String>().values()};
        for (Collection<?> c : collections) {
            // 全是Unknown Collection, overload没有动态根据instance来运行对应method的效果
            System.out.println(classify(c));
        }

        // 对
        List<Wine> wineList = Arrays.asList(new Wine(), new SparklingWine(), new Champagne());
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }

        // 到底有没有拆装箱?
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
            list2.add(i);
        }
        for (int i = 0; i < 3; i++) {
            // remove数字
            set.remove(i);
            // remove对应index的元素
            list.remove(i);
            // remove对应的Integer
            list2.remove(Integer.valueOf(i));
        }
        System.out.println(set + " " + list + " " + list2);
    }

    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        // 错误
        return "Unknown Collection";
        // 正确
        // return c instanceof Set ? "Set" : c instanceof List ? "List" : "Unknown Collection";
    }

    static class Wine {
        String name() {
            return "wine";
        }
    }

    static class SparklingWine extends Wine {

        @Override
        String name() {
            return "sparkling wine";
        }
    }

    static class Champagne extends SparklingWine {

        @Override
        String name() {
            return "champagne";
        }
    }
}
