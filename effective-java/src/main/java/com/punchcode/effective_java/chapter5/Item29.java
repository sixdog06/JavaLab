package com.punchcode.effective_java.chapter5;

import com.punchcode.effective_java.chapter5.common.Stack;

/**
 * Item 29: Favor generic types
 * @author huanruiz
 * @since 2021/12/15
 */
public class Item29 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String arg : args) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
