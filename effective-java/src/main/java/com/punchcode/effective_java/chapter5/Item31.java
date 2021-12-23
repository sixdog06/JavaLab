package com.punchcode.effective_java.chapter5;

import com.punchcode.effective_java.chapter5.common.Stack;

import java.util.*;

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

        /**
         * wildcard or not?
         */
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(1, 2);
        swap2(list1, 1, 0);
        swap2(list2, 1, 0);
        System.out.println(list1);
        System.out.println(list2);
    }

    public static <E> void swap1(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    /**
     * 对公共api来说, 这种实现方式比{@code swap1}更加灵活. todo: swap哪里不灵活了, 书里面没给例子, 我也想不出...
     */
    public static void swap2(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    /**
     * {@code List<?>}的限制, 所以无法把非null的值set进list, 那么需要{@code swapHelper}去设置,
     * {@code swapHelper}知道list是{@code List<E>}这个类型.
     */
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
