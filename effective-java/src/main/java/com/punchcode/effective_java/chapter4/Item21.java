package com.punchcode.effective_java.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 21: Design interfaces for posterity
 * @author huanruiz
 * @since 2021/12/7
 */
public class Item21 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.removeIf(s -> false);
    }
}
