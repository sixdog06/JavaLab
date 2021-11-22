package com.punchcode.effective_java.chapter2;

import com.punchcode.effective_java.chapter2.common.UtilityClass;

/**
 * Item 4: Enforce noninstantiability with a private constructor
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
