package com.punchcode.the_art_of_java_concurrency_programming.chapter4.c4_3;

import java.util.concurrent.TimeUnit;

/**
 * @author: Harry Zhang
 * @since: 16/Mar/2023
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
