package com.punchcode.effective_java.chapter2;

import com.punchcode.effective_java.chapter2.common.Lexicon;
import com.punchcode.effective_java.chapter2.common.SpellChecker;

/**
 * Item 5: Prefer dependency injection to hardwiring resources
 * @author huanruiz
 * @since 2021/11/10
 */
public class Item5 {

    public static void main(String[] args) {
        new SpellChecker(new Lexicon());
    }
}
