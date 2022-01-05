package com.punchcode.effective_java.chapter6.common;

/**
 * @author huanruiz
 * @since 2022/1/5
 */
public class Plant {

    public enum LifeCycle {
        ANNUAL,
        PERENNIAL,
        BIENNIAL
    }

    public final String name;

    public final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
