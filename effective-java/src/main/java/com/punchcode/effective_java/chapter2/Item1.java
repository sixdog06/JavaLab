package com.punchcode.effective_java.chapter2;

import java.util.*;

/**
 * Consider static factory methods instead of constructors
 * @author huanruiz
 * @since 2021/11/4
 */
public class Item1 {
    public static void main(String[] args) {
        // new对象
        Boolean bool1 = new Boolean(false);

        // 更推荐用static method返回的对象, 而不是bool1中的new对象. 自定义的对象也可以参考这种设计
        // 返回的是public static final Boolean的TRUE和FALSE
        Boolean bool2 = Boolean.valueOf(false);

        // 工厂方法返回
        List list = Collections.emptyList();

        // 放回对象根据输入不同而不同

        // 在写方法的时候, 返回的实例不一定存在(service provider framework)

    }
}
