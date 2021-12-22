package com.punchcode.effective_java.chapter5;

import com.punchcode.effective_java.chapter5.common.Stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Item 31: Use bounded wildcards to increase API flexibility
 * @author huanruiz
 * @since 2021/12/21
 */
public class Item31 {

    public static void main(String[] args) {

        Stack<Number> stack = new Stack<>();
        // 可以
        stack.push(Integer.valueOf(1));
        // 不行
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
//        stack.badPushAll(list);
        stack.goodPushAll(list);
        System.out.println(stack);

        List<Number> dest = new ArrayList<>();
        stack.popAll(dest);
        System.out.println(dest);
    }
}
