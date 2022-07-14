package com.punchcode.effective_java.chapter4;

import com.punchcode.effective_java.chapter4.common.InstrumentedHashSet;
import com.punchcode.effective_java.chapter4.common.InstrumentedSet;
import com.sun.tools.javac.util.List;

import java.util.HashSet;

/**
 * Item 18: Favor composition over inheritance
 * @author huanruiz
 * @since 2021/12/2
 */
public class Item18 {

    public static void main(String[] args) {

        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        // 不对, addAll底层调用了add
        System.out.println(s.getAddCount());

        InstrumentedSet<String> s1 = new InstrumentedSet<>(new HashSet<>());
        s1.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s1.getAddCount());
    }
}
