package com.punchcode.effective_java.chapter6.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanruiz
 * @since 2022/1/7
 */
public class Sample2 {

    /**
     * Test should pass
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    /**
     * Should fail (wrong exception)
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    /**
     * Should fail (no exception)
     */
    @ExceptionTest(ArithmeticException.class)
    @ExceptionTest(NullPointerException.class)
    public static void m3() {

    }

    /**
     * Code containing an annotation with an array parameter
     */
    @ExceptionV2Test({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad() {
        // The spec permits this method to throw either
        List<String> list = new ArrayList<>();
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}
