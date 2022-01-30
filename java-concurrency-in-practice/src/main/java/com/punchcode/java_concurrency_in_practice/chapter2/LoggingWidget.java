package com.punchcode.java_concurrency_in_practice.chapter2;

/**
 * @author huanruiz
 * @since 2022/1/30
 */
class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println(this + ": calling method");
        super.doSomething();
    }
}