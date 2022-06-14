package com.punchcode.java_concurrency_in_practice.chapter2;

/**
 * @author huanruiz
 * @since 2022/1/30
 */
class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println(this + ": calling method");
        // 调用父类的同步方法, 虽然方法不同, 但是this是用一个, 那么锁就是同一个
        super.doSomething();
    }
}