package com.punchcode.effective_java.chapter6.common;

/**
 * Enum type with constant-specific method implementations
 * @author huanruiz
 * @since 2021/12/29
 */
public enum BasicOperation implements Operation {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    /**
     * Item34: 要求枚举类必须去实现这个方法, 防止新的枚举类不实现报错.
     * Item38: 用接口定义一个模板, 让不同的类实现
     */
    public abstract double apply(double x, double y);
}
