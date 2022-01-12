package com.punchcode.effective_java.chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

/**
 * Item 42: Prefer lambdas to anonymous classes
 * 不能保证序列化和反序列化的正确性: why? todo
 * @author huanruiz
 * @since 2022/1/12
 */
public class Item42 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        /**
         * 用匿名类替换
         */
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        // 进一步优化写法
        Collections.sort(words, Comparator.comparingInt(String::length));
        // 再优化写法
        words.sort(Comparator.comparingInt(String::length));


    }

    /**
     * 第6章的Operation简化写法
     */
    public enum Operation {

        PLUS("+", Double::sum),

        MINUS("-", (x, y) -> x - y),

        TIMES("*", (x, y) -> x * y),

        DIVIDE("/", (x, y) -> x / y);

        private final String symbol;

        private final DoubleBinaryOperator op;

        Operation(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }
}
