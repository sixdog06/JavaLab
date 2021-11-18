package com.punchcode.effectivejava.chapter3.common;

import java.awt.*;
import java.util.Objects;

/**
 * @author huanruiz
 * @since 2021/11/17
 */
public class GoodColorPoint extends Point {

    private final Point point;

    private final Color color;

    public GoodColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof GoodColorPoint)) {
            return false;
        }
        GoodColorPoint cp = (GoodColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
