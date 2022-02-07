package com.punchcode.java_concurrency_in_practice.chapter2;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * 线程安全的因式分解Servlet
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
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        PrintWriter writer = resp.getWriter();
        writer.print(factors);
        super.doPost(req, resp);
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
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
