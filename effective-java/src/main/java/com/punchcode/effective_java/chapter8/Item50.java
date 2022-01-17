package com.punchcode.effective_java.chapter8;

import com.punchcode.effective_java.chapter8.common.Period;

import java.util.Date;

/**
 * Item 50: Make defensive copies when needed
 * @author huanruiz
 * @since 2022/1/17
 */
public class Item50 {

    public static void main(String[] args) {

        // Attack the internals of a Period instance
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        // Modifies internals of p! (引用是暴露的)
        end.setYear(78);
    }
}
