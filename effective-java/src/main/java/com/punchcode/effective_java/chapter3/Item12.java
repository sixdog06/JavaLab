package com.punchcode.effective_java.chapter3;

import com.punchcode.effective_java.chapter3.common.PhoneNumber;

/**
 * Item 12: Always override toString
 * @author huanruiz
 * @since 2021/11/24
 */
public class Item12 {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber(123, 456, 789);
        // 不重写, 打印的信息没有实际意义
        System.out.println(phoneNumber);
    }
}
