package com.punchcode.effective_java.chapter4;

import com.punchcode.effective_java.chapter4.common.Circle;
import com.punchcode.effective_java.chapter4.common.Figure;

/**
 * Item 23: Prefer class hierarchies to tagged classes
 * @author huanruiz
 * @since 2021/12/8
 */
public class Item23 {

    public static void main(String[] args) {
        // 靠构造器决定类型, 这种设计有问题
        new Figure(1.01d);

        // 应该替换为用继承实现
        new Circle(1.01d);
    }
}
