package com.punchcode.effective_java.chapter6;

import com.punchcode.effective_java.chapter6.common.Operation;

/**
 * Item 38: Emulate extensible enums with interfaces
 * @author huanruiz
 * @since 2022/1/5
 */
public class Item38 {

    public static void main(String[] args) {
        new Operation() {
            @Override
            public double apply(double x, double y) {
                return 0;
            }
        };
    }
}
