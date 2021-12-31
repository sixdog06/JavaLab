package com.punchcode.effective_java.chapter6.common;

/**
 * @author huanruiz
 * @since 2021/12/31
 */
public enum BadEnsemble {

    SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

    /**
     * 维护性差, 各个枚举的顺序不能变了
     * @return 需要几个音乐家
     */
    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}
