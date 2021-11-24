package com.punchcode.effective_java.chapter3;

import com.punchcode.effective_java.chapter3.common.PhoneNumber;

import java.util.HashMap;

/**
 * Item 11: Always override hashCode when you override equals
 * @author huanruiz
 * @since 2021/11/22
 */
public class Item11 {

    public static void main(String[] args) {
        HashMap<PhoneNumber, String> map = new HashMap<>(5);
        PhoneNumber phoneNumber = new PhoneNumber(123, 456, 789);
        map.put(phoneNumber, "Test");
        // 同样的对象可以得到结果
        System.out.println(map.get(phoneNumber));
        // 不同的对象, 没有重写hashCode, 得不到结果
        System.out.println(map.get(new PhoneNumber(123, 456, 789)));

        // String的hashCode有详细说明, 会限制以后的性能优化
        new String();
    }
}
