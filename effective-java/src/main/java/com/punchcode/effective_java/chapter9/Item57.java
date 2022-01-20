package com.punchcode.effective_java.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Item 57: Minimize the scope of local variables
 * @author huanruiz
 * @since 2022/1/20
 */
public class Item57 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));

        // i的scope超出了循环范围
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            Integer e = i.next();
            System.out.println(e);
        }

        // Idiom for iterating when you need the iterator
        for (Iterator<Integer> i2 = list.iterator(); i2.hasNext(); ) {
            Integer e = i2.next();
            System.out.println(e);
        }
    }
}
