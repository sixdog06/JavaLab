package com.punchcode.java_concurrency_in_practice.chapter3;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 线程安全的因式分解, 因为lastNumber和lastFactors
 * @author huanruiz
 * @since 2022/2/10
 */
public class OneValueCache {

    private final BigInteger lastNumber;

    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length); }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
