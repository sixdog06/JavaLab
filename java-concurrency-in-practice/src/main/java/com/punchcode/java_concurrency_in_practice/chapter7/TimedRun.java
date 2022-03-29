package com.punchcode.java_concurrency_in_practice.chapter7;

import java.util.concurrent.*;;

/**
 * @author huanruiz
 * @since 2022/3/29
 */
public class TimedRun {
    
    /**
     * timedRun是static的, 可以被任何线程调用, 调用线程的中断策略是未知的, 如果该线程任务已经执行完成,
     * {@code cancelExec.schedule}的延时才结束, 那么{@code taskThread.interrupt()}会造成无法推测的后果
     */
    private static final ScheduledExecutorService cancelExec = new ScheduledThreadPoolExecutor(1);
    
    public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
        final Thread taskThread = Thread.currentThread();
        // 在一段延时后调用
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        r.run();
    }
}
