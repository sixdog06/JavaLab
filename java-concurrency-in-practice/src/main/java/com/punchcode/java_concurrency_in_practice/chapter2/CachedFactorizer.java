package com.punchcode.java_concurrency_in_practice.chapter2;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 带缓存且线程安全的因式分解Servlet
 * 既没有使用原子变量类, 也没有对整个方法加锁, 把栈上变量(每个线程独有的变量)排除在锁之外
 * 符合我们非共享不加锁的原则
 * @author huanruiz
 * @since 2022/2/7
 */
public class CachedFactorizer extends HttpServlet {

    private BigInteger lastNumber;

    private BigInteger[] lastFactors;

    private long hits;

    private long cacheHits;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger i = (BigInteger)req.getAttribute("i");
        // factor只在单线程的栈上使用, 不被发布, 无需加锁
        BigInteger[] factors = null;
        // 查询, 先检查后执行
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }

        if (factors == null) {
            factors = factor(i);
            // 修改, 实时更新缓存
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        PrintWriter writer = resp.getWriter();
        writer.print(Arrays.toString(factors));
        super.doGet(req, resp);
    }

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double)cacheHits / (double)hits;
    }

    /**
     * 因式分解, 还没实现
     */
    private BigInteger[] factor(BigInteger number) {
        return new BigInteger[]{};
    }
}
