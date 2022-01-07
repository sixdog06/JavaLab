package com.punchcode.effective_java.chapter6.common;

/**
 * @author huanruiz
 * @since 2022/1/7
 */
public class Sample {

    /**
     * Test should pass public static void m2() { }
     */
    @Test
    public static void m1() {

    }

    /**
     * Test should fail
     */
    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {

    }

    /**
     * INVALID USE: nonstatic method public static void m6() {}
     */
    @Test
    public void m5() {

    }

    /**
     * Test should fail
     */
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {

    }
}
