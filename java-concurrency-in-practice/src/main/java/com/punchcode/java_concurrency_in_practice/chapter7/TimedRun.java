package com.punchcode.java_concurrency_in_practice.chapter7;

import java.util.concurrent.*;
import static com.punchcode.java_concurrency_in_practice.chapter5.Preloader.launderThrowable;

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
    
    /**
     * 修复了timedRun的问题, 但是因为用了join. 无法知道线程是正常退出(因为taskThread.interrupt()退出)还是因为join超时而返回
     */
    public static void timedRun2(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class RethrowableTask implements Runnable {
            /**
             * 在两个线程之间共享
             */
            private volatile Throwable t;
            
            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }
            
            void rethrow() {
                if (t != null) {
                    throw launderThrowable(t);
                }
            }
        }
        
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        // 任务线程开始执行
        taskThread.start();
        // 用专门的中断线程中断任务
        cancelExec.schedule(new Runnable() {
                @Override
                public void run() {
                    taskThread.interrupt();
                }
            }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }
    
    /**
     * 通过Future的取消功能来实现. 这样可以知道是因为超时退出(TimeoutException), 还是任务执行完成后或没执行完成因为中断而退出
     */
    private static final ExecutorService taskExec = Executors.newFixedThreadPool(1);
    
    public static void timedRun3(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future<?> task = taskExec.submit(r);
    
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // 超时, 可以取消任务
        } catch (ExecutionException e) {
            // exception thrown in task; rethrow
            throw launderThrowable(e.getCause());
        } finally {
            // 任务没有执行了, 这行代码没有影响. 若还在执行, 则中断任务
            task.cancel(true);
        }
    }
}
