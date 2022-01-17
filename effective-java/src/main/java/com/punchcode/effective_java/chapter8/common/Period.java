package com.punchcode.effective_java.chapter8.common;

import java.util.Date;

/**
 * Broken "immutable" time period class
 * @author huanruiz
 * @since 2022/1/17
 */
public final class Period {

    private final Date start;

    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    /**
     * Repaired constructor - makes defensive copies of parameters
     * 实际上还是可以通过accessor来访问字段并修改, 要做到完全immutable, {@code start()}和{@code end()}
     * 的返回也需要改为{@code new Date(end.getTime());}
     */
    // public Period(Date start, Date end) {
    //     this.start = new Date(start.getTime());
    //     this.end = new Date(end.getTime());
    //     if (this.start.compareTo(this.end) > 0)
    //         throw new IllegalArgumentException(
    //                 this.start + " after " + this.end);
    // }
}
