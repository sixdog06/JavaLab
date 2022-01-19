package com.punchcode.effective_java.chapter8;

/**
 * Item 53: Use varargs judiciously
 * @author huanruiz
 * @since 2022/1/18
 */
public class Item53 {

    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(min(1));
        System.out.println(min2(1));
    }

    static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    /**
     * The WRONG way to use varargs to pass one or more arguments!
     */
    static int min(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Too few arguments");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    /**
     * The right way to use varargs to pass one or more arguments
     */
    static int min2(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }
}
