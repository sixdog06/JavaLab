package com.punchcode.java_concurrency_in_practice.chapter4.common;

/**
 * 这个类不是线程安全的, 但是追踪器类安全
 * @author huanruiz
 * @since 2022/2/14
 */
public class MutablePoint {

    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
