package com.punchcode.java_concurrency_in_practice.chapter5;

import com.punchcode.java_concurrency_in_practice.chapter5.common.DataLoadException;
import com.punchcode.java_concurrency_in_practice.chapter5.common.ProductInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huanruiz
 * @since 2022/2/24
 */
public class Preloader {

    private final Thread thread = new Thread();

    private final FutureTask<ProductInfo> future = new FutureTask<>(new Callable<ProductInfo>() {

        @Override
        public ProductInfo call() {
            return loadProductInfo();
        }
    });

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws InterruptedException, DataLoadException {
        try {
            // 在完成计算后返回结果(异步)
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                // 数据加载出错导致的exception(已知异常)
                throw (DataLoadException)cause;
            } else {
                throw launderThrowable(cause);
            }
        }
    }

    /**
     * 加载商品信息(一些运算逻辑)
     */
    private ProductInfo loadProductInfo() {
        return new ProductInfo();
    }

    /**
     * 一些异常处理
     */
    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalStateException("Not unchecked", t);
        }
    }
}
