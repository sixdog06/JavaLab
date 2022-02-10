package com.punchcode.java_concurrency_in_practice.chapter3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huanruiz
 * @since 2022/2/10
 */
public class ThreeStooges {

    /**
     * Set可变, 但是构造后无法修改
     */
    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}