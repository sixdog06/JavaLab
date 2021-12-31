package com.punchcode.effective_java.chapter6.common;

/**
 * 用字段代替{@code ordinal}方法
 * @author huanruiz
 * @since 2021/12/31
 */
public enum GoodEnsemble {

    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    GoodEnsemble(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}
