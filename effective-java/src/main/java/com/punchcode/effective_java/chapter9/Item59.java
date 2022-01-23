package com.punchcode.effective_java.chapter9;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Item 59: Know and use the libraries
 * @author huanruiz
 * @since 2022/1/21
 */
public class Item59 {

    /**
     * Common but deeply flawed!
     */
    static Random rnd = new Random();

    static SplittableRandom rnd2 = new SplittableRandom();

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        int low2 = 0;
        int low3 = 0;
        int low4 = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
            if (rnd.nextInt(n) < n / 2) {
                low2++;
            }
            if (ThreadLocalRandom.current().nextInt(n) < n / 2) {
                low3++;
            }
            if (rnd2.nextInt(n) < n / 2) {
                low4++;
            }
        }
        // 输出应该是500000左右, 但实际上是666666左右
        System.out.println(low);
        // 正确调用
        System.out.println(low2);
        // 性能更好的调用
        System.out.println(low3);
        // fork join pools and parallel streams调用
        System.out.println(low4);
    }

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }
}
