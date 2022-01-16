package com.punchcode.effective_java.chapter7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Item 46: Prefer side-effect-free functions in streams
 * @author huanruiz
 * @since 2022/1/15
 */
public class Item46 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("A", "B", "C", "B", "B", "C");
        // 写法1, 乱用foreach
        Map<String, Long> freq1 = new HashMap<>(5);
        words.forEach(word -> {
            freq1.merge(word.toLowerCase(), 1L, Long::sum);
        });
        System.out.println(freq1);

        // 写法2
        Map<String, Long> freq2;
        freq2 = words.stream().collect(groupingBy(String::toLowerCase, counting()));
        System.out.println(freq2);

        // Pipeline to get a top-ten list of words from a frequency table
        List<String> topTen = freq2.keySet().stream() .sorted(comparing(freq2::get).reversed()).limit(10)
                .collect(Collectors.toList());
        System.out.println(topTen);
    }
}
