package com.punchcode.effective_java.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Item 54: Return empty collections or arrays, not nulls
 * @author huanruiz
 * @since 2022/1/19
 */
public class Item54 {

    public static void main(String[] args) {

    }

    /**
     * 为null返回空list
     */
    public List<String> getCheeses(List<String> cheesesInStock) {
        return cheesesInStock.isEmpty() ? Collections.emptyList()
                : new ArrayList<>(cheesesInStock);
    }

    /**
     * 为null返回空array, 如果还觉得影响性能, 那么zero-length arrays定义为静态常量反复使用
     */
    public String[] getCheesesArray(List<String>  cheesesInStock) {
        return cheesesInStock.toArray(new String[0]);
    }
}
