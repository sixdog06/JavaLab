package com.punchcode.effective_java.chapter6;

import com.punchcode.effective_java.chapter6.common.Text;

import java.util.EnumSet;

/**
 * Item 36: Use EnumSet instead of bit fields
 * @author huanruiz
 * @since 2021/12/31
 */
public class Item36 {

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }
}
