package com.punchcode.effectivejava.chapter2.common;

import java.util.List;
import java.util.Objects;

/**
 * @author huanruiz
 * @since 2021/11/10
 */
public class SpellChecker {

    private final Lexicon dictionary;

    /**
     * SpellChecker依赖dictionary, 只是单例/静态工厂不能实现这种依赖的行为
     * @param dictionary
     */
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String typo) {
        return null;
    }
}