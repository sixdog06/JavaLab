package com.punchcode.effective_java.chapter6.common;

import java.lang.annotation.*;

/**
 * Annotation type with a parameter
 * Repeatable让给注解可以在方法上重复使用
 * @author huanruiz
 * @since 2022/1/7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {

    /**
     * one parameter
     */
    Class<? extends Throwable> value();
}