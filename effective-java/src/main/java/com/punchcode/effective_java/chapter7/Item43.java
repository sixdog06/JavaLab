package com.punchcode.effective_java.chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * Item 43: Prefer method references to lambdas
 * @author huanruiz
 * @since 2022/1/12
 */
public class Item43 {

    private static final String KEY = "key";

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(5);
        map.put(KEY, 2);
        // 长点
        map.merge(KEY, 1, (count, incr) -> count + incr);
        // 短点
        map.merge(KEY, 1, Integer::sum);
        System.out.println(map);
    }
}
