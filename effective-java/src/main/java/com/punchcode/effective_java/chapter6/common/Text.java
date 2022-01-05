package com.punchcode.effective_java.chapter6.common;

import java.util.Set;

/**
 * @author huanruiz
 * @since 2022/1/5
 */
public class Text {

    /**
     * 没有必要用{@code public static final int STYLE_BOLD = 1 << 0;}这种bit的形式来表示不同的类型.
     * 直接用枚举表示, 并用EnumSet来表示不同类型的或操作即可. 或操作在bit的形式下就是取集合的目的.
     */
    public enum Style {
        BOLD,
        ITALIC,
        UNDERLINE,
        STRIKETHROUGH
    }

    /**
     * Any Set could be passed in, but EnumSet is clearly best
     */
    public void applyStyles(Set<Style> styles) {

    }
}
