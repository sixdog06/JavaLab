package com.punchcode.effective_java.chapter5;

import com.punchcode.effective_java.chapter5.common.Chooser;
import com.punchcode.effective_java.chapter5.common.GoodChooser;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 28: Prefer lists to arrays
 * @author huanruiz
 * @since 2021/12/14
 */
public class Item28 {

    public static void main(String[] args) {
        Object[] objectArray = new Long[1];
        // Throws ArrayStoreException
//        objectArray[0] = "I don't fit in";

        // Won't compile!
        // Incompatible types ol.add("I don't fit in");
//        List<Object> ol = new ArrayList<Long>();

        /**
         *  Why generic array creation is illegal - won't compile!
            List<String>[] stringLists = new List<String>[1];
            List<Integer> intList = List.of(42); // (2)
            Object[] objects = stringLists; // (3)
            objects[0] = intList; // (4)
            String s = stringLists[0].get(0); // (5)
         */

        new Chooser(new ArrayList());
        new GoodChooser<>(new ArrayList<>());
    }
}
