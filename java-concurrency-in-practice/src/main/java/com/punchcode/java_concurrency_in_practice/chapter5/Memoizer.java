package com.punchcode.java_concurrency_in_practice.chapter5;

import com.punchcode.java_concurrency_in_practice.chapter5.common.Computable;

import java.util.concurrent.*;

import static com.punchcode.java_concurrency_in_practice.chapter5.Preloader.launderThrowable;

/**
 * 比Memoizer3更好的实现, 但是没有解决缓存缓存的问题. 可以通过Future的子类来设置过期时间从而实现过期
 * @author huanruiz
 * @since 2022/3/2
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {

                    @Override
                    public V call() throws InterruptedException {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(eval);
                // 避免重算
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                // 防止cache pollution, 因为异步计算可能会取消
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                throw launderThrowable(e.getCause());
            }
        }
    }
}
