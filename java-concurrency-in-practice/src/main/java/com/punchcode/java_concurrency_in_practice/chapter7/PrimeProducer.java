package com.punchcode.java_concurrency_in_practice.chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * PrimeGenerator的阻塞队列版, 这时候需要用interrupt来实现cancel, 防止阻塞队列阻塞后线程读不到cancel信号量, 导致任务无法停止
 * @author: Harry Zhang
 * @since: 27/Jul/2022
 */
public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException consumed) {
            // Allow thread to exit
        }
    }

    public void cancel() {
        interrupt();
    }
}
