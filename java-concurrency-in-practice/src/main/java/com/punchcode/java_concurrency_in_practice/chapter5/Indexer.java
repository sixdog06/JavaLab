package com.punchcode.java_concurrency_in_practice.chapter5;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * @author huanruiz
 * @since 2022/2/21
 */
public class Indexer {

    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File file) {
        // do something
    }
}
