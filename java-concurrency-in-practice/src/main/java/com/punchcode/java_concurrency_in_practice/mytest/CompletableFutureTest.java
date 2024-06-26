package com.punchcode.java_concurrency_in_practice.mytest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author huanruiz
 * @since 2024/6/26
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture completableFuture = new CompletableFuture();
        // new Thread(()->{
        //     System.out.println("异步任务......");
        //     // 执行完成后可以往CompletableFuture对象里面写出返回值
        //     completableFuture.complete(Thread.currentThread().getName());
        // }).start();
        // // 主线程获取异步任务执行结果
        // System.out.println("main线程获取执行结果：" + completableFuture.get());
        // for (int i = 1; i <= 3; i++){
        //     System.out.println("main线程 - 输出："+i);
        // }


        // CompletableFuture<String> supplyCF = CompletableFuture.supplyAsync(CompletableFutureTest::evenNumbersSum);
        // // 执行成功的回调
        // supplyCF.thenAccept(System.out::println);
        // // 执行过程中出现异常的回调
        // supplyCF.exceptionally((e)->{
        //     e.printStackTrace();
        //     return "异步任务执行过程中出现异常....";
        // });
        // // 主线程执行打印1234...操作
        // // 因为如果不为CompletableFuture指定线程池执行任务的情况下，
        // // CompletableFuture默认是使用ForkJoinPool.commonPool()的线程
        // // 同时是作为main线程的守护线程进行的，如果main挂了，执行异步任
        // // 务的线程也会随之终止结束，并不会继续执行异步任务



        // 创建一个异步任务，已经给定返回值了
        CompletableFuture cf =
                CompletableFuture.supplyAsync(CompletableFutureTest::evenNumbersSum)
                        // 链式编程：基于上个任务的返回继续执行新的任务
                        .thenApply(r -> {
                            System.out.println("获取上个任务的执行结果：" + r);
                            // 通过上个任务的执行结果完成计算：求和100所有数
                            return r + oddNumbersSum();
                        }).thenApplyAsync(r -> {
                            System.out.println("获取上个任务的执行结果：" + r);
                            Integer i = r / 0; // 拋出异常
                            return r;
                        }).handle((param, throwable) -> {
                            if (throwable == null) {
                                return param * 2;
                            }
                            // 获取捕获的异常
                            System.out.println(throwable.getMessage());
                            System.out.println("我可以在上个任务" +
                                    "抛出异常时依旧执行....");
                            return -1;
                        }).thenCompose(x ->
                                CompletableFuture.supplyAsync(() -> x+1
                                )).thenRun(() -> {
                            System.out.println("我是串行无返回任务....");
                        });

        for (int i = 1; i <= 10; i++){
            System.out.println("main线程 - 输出："+i);
            Thread.sleep(500);
        }
    }

    private static int evenNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) sum += i;
        }
        return sum;
    }

    private static int oddNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) sum += i;
        }
        return sum;
    }
}
