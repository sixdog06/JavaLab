package com.punchcode.effective_java.chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Minimize the accessibility of classes and members
 * @author huanruiz
 * @since 2021/11/28
 */
public class Item15 {

    public static void main(String[] args) {
        String[] array1 = ArrayClass.ARRAY_1;
        System.out.println(array1.length);
        // 对象不能改, 但对象的引用可以改
        array1[1] = "aha";
        System.out.println(Arrays.toString(ArrayClass.ARRAY_1));

        System.out.println(ArrayClass.ARRAY_2_LIST);
        System.out.println(Arrays.toString(ArrayClass.values()));
    }
}

class ArrayClass {

    /**
     * unsafe
     */
    public final static String[] ARRAY_1 = {"a", "b", "c"};

    /**
     * safe
     */
    private final static String[] ARRAY_2 = {"a", "b", "c"};

    public static final List<String> ARRAY_2_LIST = Collections.unmodifiableList(Arrays.asList(ARRAY_2));

    public static final String[] values() {
        return ARRAY_2.clone();
    }
}
