package com.punchcode.effective_java.chapter6;

import com.punchcode.effective_java.chapter6.common.ExceptionTest;
import com.punchcode.effective_java.chapter6.common.ExceptionTestContainer;
import com.punchcode.effective_java.chapter6.common.ExceptionV2Test;
import com.punchcode.effective_java.chapter6.common.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Item 39: Prefer annotations to naming patterns
 * @author huanruiz
 * @since 2022/1/7
 */
public class Item39 {

    public static void main(String[] args) throws ClassNotFoundException {
        // test of annotation test
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.punchcode.effective_java.chapter6.common.Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            // 有Test注解才跑
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n\n", passed, tests - passed);

        // test of ExceptionTest
        tests = 0;
        passed = 0;
        testClass = Class.forName("com.punchcode.effective_java.chapter6.common.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    // 无报错, 算failed
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    // 抛出的是注解中标注的报错, 算通过
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n\n", passed, tests - passed);

        // test of ExceptionTest(array version)
        tests = 0;
        passed = 0;
        testClass = Class.forName("com.punchcode.effective_java.chapter6.common.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionV2Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionV2Test.class).value();
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n\n", passed, tests - passed);

        // Repeatable annotation test
        tests = 0;
        passed = 0;
        testClass = Class.forName("com.punchcode.effective_java.chapter6.common.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    ExceptionTest[] excTests = m.getAnnotationsByType(ExceptionTest.class);
                    for (ExceptionTest excTest : excTests) {
                        if (excTest.value().isInstance(exc)) { passed++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
