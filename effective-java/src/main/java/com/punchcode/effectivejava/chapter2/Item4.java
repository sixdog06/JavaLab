package com.punchcode.effectivejava.chapter2;

import com.punchcode.effectivejava.chapter2.common.UtilityClass;

import java.util.Arrays;

/**
 * @author huanruiz
 * @since 2021/11/9
 */
public class Item4 {

    public static void main(String[] args) {
        //UtilityClass isntance = new UtilityClass();
        UtilityClass.staticMethod();

        //Math, Arrays

        // 类的内部也无法实例化
        // UtilityClass.wrongMethod();
    }
}
