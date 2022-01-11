package com.punchcode.effective_java.chapter6;

import com.punchcode.effective_java.chapter6.common.Bigram;

import java.util.HashSet;
import java.util.Set;

/**
 * Item 40: Consistently use the Override annotation
 * @author huanruiz
 * @since 2022/1/10
 */
public class Item40 {

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        // 结果是260, 为什么? 看Bigram的equals, 每个Bigram的copy都和其他不一样
        System.out.println(s.size());
    }
}
