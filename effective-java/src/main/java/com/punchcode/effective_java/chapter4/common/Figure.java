package com.punchcode.effective_java.chapter4.common;

/**
 * @author huanruiz
 * @since 2021/12/8
 */
public class Figure {

    enum Shape { RECTANGLE, CIRCLE };

    /**
     * Tag field - the shape of this figure
     */
    final Shape shape;

    /**
     * These fields are used only if shape is RECTANGLE
     */
    double length;

    double width;

    /**
     * This field is used only if shape is CIRCLE
     */
    double radius;

    /**
     * Constructor for circle
     */
    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    /**
     * Constructor for rectangle
     */
    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch(shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
