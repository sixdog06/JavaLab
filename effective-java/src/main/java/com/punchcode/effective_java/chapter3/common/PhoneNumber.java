package com.punchcode.effective_java.chapter3.common;

import com.google.common.hash.Hashing;

import java.util.Objects;

/**
 * equals的标准实现
 * @author huanruiz
 * @since 2021/11/22
 */
public final class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    /**
     * 通过hashCode字段, 可以实现懒计算, 只有hashCode为0时才计算, 否则直接返回hashCode
     */
//    private int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short)val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    /**
     * Typical hashCode method
     *  guava提供了更优的hash method, 如{@code Hashing.crc32()}.
     *  Objects提供了{@code Objects.hash(lineNum, prefix, areaCode)}, 但是性能较差, 看源码会发现
     *  这个方法用了{@code Object a[]}数组来存值, 使用了不必要的空间, 并且对于基础类型, 拆箱装箱也会
     *  有额外的性能损耗
     */
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}
