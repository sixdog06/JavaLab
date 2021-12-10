package com.punchcode.effective_java.chapter4;

/**
 * Item 25: Limit source files to a single top-level class
 * @author huanruiz
 * @since 2021/12/9
 */
public class Item25 {

    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

    /**
     * 一个文件下不要放多个类, 如果内部需要就用 {@code private static class}代替
     */
    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}

