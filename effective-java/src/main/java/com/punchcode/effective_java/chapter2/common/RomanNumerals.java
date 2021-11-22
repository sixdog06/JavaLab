package com.punchcode.effective_java.chapter2.common;

import java.util.regex.Pattern;

/**
 * @author huanruiz
 * @since 2021/11/11
 */
public class RomanNumerals {

    // 只创建一次, 多次创建会多次使用有限状态机, 开销大
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
