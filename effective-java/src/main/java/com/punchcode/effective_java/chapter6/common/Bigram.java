package com.punchcode.effective_java.chapter6.common;

/**
 * 不用override造成的后果
 * @author huanruiz
 * @since 2022/1/11
 */
public class Bigram {

    private final char first;

    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /**
     * 参数是Bigram类型, 并没有重写Object的equals
     */
    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }
}