package com.punchcode.effective_java.chapter7.common;

import java.util.*;

/**
 * @author huanruiz
 * @since 2022/1/17
 */
public class PowerSet {

    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30) {
            throw new IllegalArgumentException("Set too big " + s);
        }

        return new AbstractList<Set<E>>() {

            @Override
            public int size() {
                // 2 to the power srcSize
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set)o);
            }

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }
        };
    }
}