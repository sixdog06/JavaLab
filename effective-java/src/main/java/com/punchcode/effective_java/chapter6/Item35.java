package com.punchcode.effective_java.chapter6;

import com.punchcode.effective_java.chapter6.common.BadEnsemble;
import com.punchcode.effective_java.chapter6.common.GoodEnsemble;

/**
 * Item 35: Use instance fields instead of ordinals
 * @author huanruiz
 * @since 2021/12/29
 */
public class Item35 {

    public static void main(String[] args) {
        System.out.println(BadEnsemble.SOLO.numberOfMusicians());
        System.out.println(GoodEnsemble.SOLO.numberOfMusicians());
    }
}
