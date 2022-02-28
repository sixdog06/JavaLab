package com.punchcode.java_concurrency_in_practice.chapter5;

import com.punchcode.java_concurrency_in_practice.chapter5.common.Computable;

import java.math.BigInteger;

/**
 * @author huanruiz
 * @since 2022/2/28
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) {
        // after deep thought...
        return new BigInteger(arg);
    }
}
