package com.punchcode.effective_java.chapter3.common;

import java.util.Objects;

/**
 * violates symmetry!
 * @author huanruiz
 * @since 2021/11/16
 */
public final class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    /**
     * 错误版本
     */
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//        // One-way interoperability!
//        if (o instanceof String) {
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
//    }

    /**
     * 正确版本, CaseInsensitiveString和String比较则返回false
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}
