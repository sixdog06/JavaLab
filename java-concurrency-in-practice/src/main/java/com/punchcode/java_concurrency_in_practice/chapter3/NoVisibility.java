package com.punchcode.java_concurrency_in_practice.chapter3;

/**
 * 没有同步的情况下共享变量
 * ReaderThread读不到ready为true的值, 导致程序无法终止. 也有可能读到了ready但是读不到number的值
 * @author huanruiz
 * @since 2022/2/8
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().run();
        number = 42;
        ready = true;
    }
}
