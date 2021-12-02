package com.punchcode.effective_java.chapter4;

/**
 * Item 17: Minimize mutability
 * @author huanruiz
 * @since 2021/12/1
 */
public class Item17 {

    public static void main(String[] args) {
        new Complex(1, 2);
        System.out.println(Complex.ZERO);
    }
}
