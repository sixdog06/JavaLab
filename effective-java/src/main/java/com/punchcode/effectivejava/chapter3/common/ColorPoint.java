package com.punchcode.effectivejava.chapter3.common;

import java.awt.*;

/**
 * violates transitivity!
 *
 * <p><tt>Point</tt> class comes from Abstract Window Toolkit
 * @author huanruiz
 * @since 2021/11/16
 */
public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * 错误版本, 满足symmetry ,但是不满足transitivity
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }
        // o is a ColorPoint, do a full comparison
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    /**
     * todo: 书上的代码似乎不太对
     * 书上想表达: 虽然满足了transitivity, 但是违反<strong>Liskov substitution principle</strong>.
     * 其他Point的subclass的equals会不对
     */
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }
//        Point p = (Point)o;
//        return p.x == x && p.y == y;
//    }
}
