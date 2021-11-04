package com.punchcode.effectivejava.chapter2;

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
        Boolean bool2 = Boolean.valueOf(false);
    }
}
