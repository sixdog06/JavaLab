package com.punchcode.java_concurrency_in_practice.chapter3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author huanruiz
 * @since 2022/2/10
 */
public class VolatileCachedFactorizer extends HttpServlet {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger i = (BigInteger)req.getAttribute("i");
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        PrintWriter writer = resp.getWriter();
        writer.print(Arrays.toString(factors));
        super.doGet(req, resp);
    }

    /**
     * 因式分解, 还没实现
     */
    private BigInteger[] factor(BigInteger number) {
        return new BigInteger[]{};
    }
}
