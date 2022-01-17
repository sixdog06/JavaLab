package com.punchcode.effective_java.chapter7;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

/**
 * Item 48: Use caution when making streams parallel
 * @author huanruiz
 * @since 2022/1/17
 */
public class Item48 {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
        System.out.println("cost: " + (System.currentTimeMillis() - start));

        /**
         * Stream.iterate无法parallel
         */
        // start = System.currentTimeMillis();
        // primes().parallel().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        //         .filter(mersenne -> mersenne.isProbablePrime(50))
        //         .limit(20)
        //         .forEach(System.out::println);
        // System.out.println("cost: " + (System.currentTimeMillis() - start));
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
