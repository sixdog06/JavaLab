package com.punchcode.the_art_of_java_concurrency_programming.chapter8.c8_2;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 银行流水处理服务类, 合并
 * @author huanruiz
 * @since 2023/5/1
 */
public class BankService implements Runnable {

    private static final int count = 4;

    /**
     * 创建 4 个屏障, 处理完之后执行当前类的 run 方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * 假设只有4个sheet, 所以只启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(count);
    
    /**
     * 保存每个sheet计算出的银流结果
     */
    private Map<String, Integer> sheetBankStatementCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < count; i++) {
            executor.execute(() -> {
                // 计算当前sheet的银流数据, 计算代码省略

                // 流水计算完成, 插入一个屏障
                sheetBankStatementCount.put(Thread.currentThread().getName(), 1);
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankStatementCount.entrySet()) {
            result += sheet.getValue();
        }
        // 将结果输出 sheetBankStatementCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankService bankStatementCount = new BankService();
        bankStatementCount.count();
    }
}
