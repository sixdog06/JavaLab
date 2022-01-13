package com.punchcode.effective_java.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Item 44: Favor the use of standard functional
 * @author huanruiz
 * @since 2022/1/12
 */
public class Item44 implements Predicate<String> {

    private static final String STRING_I_WANT = "I am happy";

    private static final String STRING_I_DONT_WANT = "I am sad";

    public static void main(String[] args) {
        List<String> list = Arrays.asList(STRING_I_WANT, STRING_I_DONT_WANT);
        list.stream().filter(new Item44()).forEach(System.out::println);
    }

    @Override
    public boolean test(String str) {
        if (Objects.equals(str, STRING_I_WANT)) {
            return true;
        } else {
            return false;
        }
    }
}
