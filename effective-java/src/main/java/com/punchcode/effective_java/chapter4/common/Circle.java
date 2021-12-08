package com.punchcode.effective_java.chapter4.common;

/**
 * @author huanruiz
 * @since 2021/12/8
 */
public class Circle extends GoodFigure {

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}