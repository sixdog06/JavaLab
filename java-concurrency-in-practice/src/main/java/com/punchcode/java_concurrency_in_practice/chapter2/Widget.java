package com.punchcode.java_concurrency_in_practice.chapter2;

/**
 * 内置锁可重入, 否则会死锁, 因为Widget的锁已经被持有了
 * @author huanruiz
 * @since 2022/1/30
 */
public class Widget {

    public synchronized void doSomething() {
        System.out.println(this + ": calling method(super)");
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }
}
