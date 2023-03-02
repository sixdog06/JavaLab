package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_8;

/**
 * @author: Harry Zhang
 * @since: 02/Mar/2023
 */
public class InstanceFactory {

    private static class InstanceHolder {
        public static Object instance = new Object();
    }

    public static Object getInstance() {
        return InstanceHolder.instance ; // 这里将导致InstanceHolder类被初始化
    }
}
