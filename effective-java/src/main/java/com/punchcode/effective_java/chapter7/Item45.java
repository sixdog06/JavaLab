package com.punchcode.effective_java.chapter7;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Item 45: Use streams judiciously
 * @author huanruiz
 * @since 2022/1/13
 */
public class Item45 {

    private static final String FILE_PATH = "effective-java/src/main/resources/static/anagrams";

    public static void main(String[] args) throws IOException {
        /**
         * 打印Anagrams的三种写法, 第一种是普通写法
         */
        File dictionary = new File(FILE_PATH);
        // 每组最少的单词数
        int minGroupSize = 2;
        Map<String, Set<String>> groups = new HashMap<>(5);
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        }
        System.out.println();

        // 第二种: 有大病就这样写, 反正我不想看
        Path dictionary2 = Paths.get(FILE_PATH);
        try (Stream<String> words = Files.lines(dictionary2)) {
            words.collect(
                    groupingBy(word -> word.chars().sorted()
                            .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                            .toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
        System.out.println();

        // 第三种: 简化写法
        dictionary2 = Paths.get(FILE_PATH);
        try (Stream<String> words = Files.lines(dictionary2)) {
            words.collect(groupingBy(Item45::alphabetize))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    // 注意命名, 保证可读性
                    .forEach(group -> System.out.println(group.size() + ": " + group));
        }

        /**
         * 拆char有风险, chars返回的是IntStream
         */
        "Hello world!".chars().forEach(System.out::print);
        // 正确写法, 大那是避免这种拆char的逻辑
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
    }

    /**
     * <b>Using helper methods is even more important for readability in stream pipelines than in iterative code<b/>
     */
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
