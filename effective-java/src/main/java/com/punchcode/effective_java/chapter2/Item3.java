package com.punchcode.effective_java.chapter2;

import com.punchcode.effective_java.chapter2.common.Elvis;

/**
 * Item 3: Enforce the singleton property with a private constructor or an enum type
 * @author huanruiz
 * @since 2021/11/9
 */
public class Item3 {

    public static void main(String[] args) {
        // wrong
//        Elvis instance0 = new Elvis();
        Elvis instance1 = Elvis.INSTANCE;
        Elvis instance2 = Elvis.getInstance();

    }
}
