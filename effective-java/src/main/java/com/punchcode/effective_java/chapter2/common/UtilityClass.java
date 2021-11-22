package com.punchcode.effective_java.chapter2.common;

/**
 * @author huanruiz
 * @since 2021/11/9
 */
public class UtilityClass {

    // 不能实例化
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void staticMethod() {
        System.out.println("this is a static method");
    }

    public static void wrongMethod() {
        new UtilityClass();
    }
}
