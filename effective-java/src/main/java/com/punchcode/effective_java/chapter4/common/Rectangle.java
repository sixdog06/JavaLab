package com.punchcode.effective_java.chapter4.common;

/**
 * @author huanruiz
 * @since 2021/12/8
 */
class Rectangle extends GoodFigure {

    final double length;

    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
