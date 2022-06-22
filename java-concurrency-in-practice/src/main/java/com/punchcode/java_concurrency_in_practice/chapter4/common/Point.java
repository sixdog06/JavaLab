package com.punchcode.java_concurrency_in_practice.chapter4.common;

/**
 * immutable class
 * @author huanruiz
 * @since 2022/2/15
 */
public class Point {

    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
