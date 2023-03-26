package com.punchcode.the_art_of_java_concurrency_programming.chapter4.c4_1;

/**
 * @author: Harry Zhang
 * @since: 20/Mar/2023
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                // 不会执行
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
