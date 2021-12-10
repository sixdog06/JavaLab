package com.punchcode.effective_java.chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * Item 24: Favor static member classes over nonstatic todo blog还有两种type
 * @author huanruiz
 * @since 2021/12/8
 */
public class Item24 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(10);
    }
}
