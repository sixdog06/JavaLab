package com.punchcode.java_concurrency_in_practice.mytest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author huanruiz
 * @since 2024/6/26
 */
public class CreateThread {

    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.run();

        new Thread(MyThread::new).start();

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable("futureTask"));
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        System.out.println("");

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(new MyCallable("all1"), new MyCallable("all2")));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        String s = executorService.invokeAny(Arrays.asList(new MyCallable2("any1"), new MyCallable("any2")));
        System.out.println(s);

        executorService.shutdown();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("good boy");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("good boy2");
    }
}

class MyCallable implements Callable<String> {

    private final String msg;

    public MyCallable(String msg) {
        this.msg = msg;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return msg;
    }
}

class MyCallable2 implements Callable<String> {

    private final String msg;

    public MyCallable2(String msg) {
        this.msg = msg;
    }

    @Override
    public String call() throws Exception {
        throw new Exception();
    }
}