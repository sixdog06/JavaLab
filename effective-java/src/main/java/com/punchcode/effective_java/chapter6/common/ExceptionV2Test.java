package com.punchcode.effective_java.chapter6.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation type with array of parameters
 * @author huanruiz
 * @since 2022/1/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionV2Test {

    /**
     * arrays of parameters
     */
    Class<? extends Exception>[] value();
}
