package com.punchcode.effective_java.chapter4;

import com.punchcode.effective_java.chapter4.common.Complex;

/**
 * Item 17: Minimize mutability
 * @author huanruiz
 * @since 2021/12/1
 */
public class Item17 {

    public static void main(String[] args) {
        System.out.println(Complex.valueOf(1, 2));
        System.out.println(Complex.ZERO);
    }
}
