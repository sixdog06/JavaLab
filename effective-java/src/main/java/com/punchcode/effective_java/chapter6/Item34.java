package com.punchcode.effective_java.chapter6;

import com.punchcode.effective_java.chapter6.common.Operation;
import com.punchcode.effective_java.chapter6.common.Planet;

import java.util.Arrays;

/**
 * Item 34: Use enums instead of int constants
 * @author huanruiz
 * @since 2021/12/28
 */
public class Item34 {

    public static void main(String[] args) {
        System.out.println(Planet.EARTH);
        System.out.println(Arrays.asList(Planet.values()));

        System.out.println(Operation.PLUS.apply(1, 2));
    }
}
