package com.punchcode.java_concurrency_in_practice.chapter5.common;

/**
 * A为输入, V为输出
 * @author huanruiz
 * @since 2022/2/28
 */
public interface Computable<A, V> {

    /**
     * 计算逻辑
     */
    V compute(A arg) throws InterruptedException;
}
