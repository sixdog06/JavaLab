package com.punchcode.effective_java.chapter2;

import com.punchcode.effective_java.chapter2.common.RomanNumerals;

/**
 * Item 6: Avoid creating unnecessary objects
 * @author huanruiz
 * @since 2021/11/10
 */
public class Item6 {

    public static void main(String[] args) {

        // 多创建了一个实例
        String str1 = new String("bikini");

        // 在字符串常量池可复用, 同样道理, 也要考虑静态工厂方法
        String str2 = "bikini";

        // 开销大的, 要重复是用的对象只创建一次
        RomanNumerals.isRomanNumeral(str2);
    }

    private static long sum() {
        // 应该用long
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            // 频繁装箱, 影响性能
            sum += i;
        }
        return sum;
    }
}
