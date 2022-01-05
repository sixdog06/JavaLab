package com.punchcode.effective_java.chapter6;

import com.punchcode.effective_java.chapter6.common.Plant;

import java.util.*;
import java.util.stream.Collectors;

import static com.punchcode.effective_java.chapter6.common.Plant.LifeCycle.ANNUAL;
import static com.punchcode.effective_java.chapter6.common.Plant.LifeCycle.PERENNIAL;

/**
 * Item 37: Use EnumMap instead of ordinal indexing
 * @author huanruiz
 * @since 2022/1/5
 */
public class Item37 {

    public static void main(String[] args) {

        List<Plant> garden = new ArrayList();
        garden.add(new Plant("a", ANNUAL));
        garden.add(new Plant("b", PERENNIAL));
        garden.add(new Plant("c", PERENNIAL));

        // 普通Map
        System.out.println(garden.stream().collect(Collectors.groupingBy(p -> p.lifeCycle)));
        // EnumMap
        System.out.println(garden.stream().collect(Collectors.groupingBy(p -> p.lifeCycle,
                () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet())));
    }
}
