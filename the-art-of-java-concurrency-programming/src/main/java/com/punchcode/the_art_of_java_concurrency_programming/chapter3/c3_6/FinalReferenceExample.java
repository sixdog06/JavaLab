package com.punchcode.the_art_of_java_concurrency_programming.chapter3.c3_6;

/**
 * @author: Harry Zhang
 * @since: 28/Feb/2023
 */
public class FinalReferenceExample {

    final int[] intArray; // final是引用类型

    static FinalReferenceExample obj;

    public FinalReferenceExample() { // 构造函数
        intArray = new int[1]; // 1
        intArray[0] = 1; // 2
    }

    public static void writerOne() { // 写线程A执行
        obj = new FinalReferenceExample (); // 3
    }

    /**
     * 线程B的操作与线程C的操作可能重排序, 因为线程B的操作并不在构造器内
     */
    public static void writerTwo() { // 写线程B执行
        obj.intArray[0] = 2; // 4
    }

    public static void reader() { // 读线程C执行
        if (obj != null) { // 5
            int temp1 = obj.intArray[0]; // 6
        }
    }
}
