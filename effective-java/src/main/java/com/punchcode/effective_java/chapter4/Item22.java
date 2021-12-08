package com.punchcode.effective_java.chapter4;

import java.io.ObjectStreamConstants;

/**
 * Item 22: Use interfaces only to define types
 * @author huanruiz
 * @since 2021/12/8
 */
public class Item22 {

    public static void main(String[] args) {
        // 这种constant interface pattern是不应该出现的
        int protocolVersion2 = ObjectStreamConstants.PROTOCOL_VERSION_2;

    }
}
