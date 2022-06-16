package com.punchcode.java_concurrency_in_practice.chapter2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 粗粒度地岁整个方法加锁(很不好)
 * @author huanruiz
 * @since 2022/6/16
 */
public class SynchronizedFactorizer extends HttpServlet {
    
    private BigInteger lastNumber;
    
    private BigInteger[] lastFactors;
    
    @Override
    protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger i = (BigInteger)req.getAttribute("i");
        PrintWriter writer = resp.getWriter();
        if (i.equals(lastNumber)) {
            writer.print(Arrays.toString(lastFactors));
        } else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            writer.print(Arrays.toString(factors));
        }
        super.doGet(req, resp);
    }
    
    
    /**
     * 因式分解, 还没实现
     */
    private BigInteger[] factor(BigInteger number) {
        return new BigInteger[]{};
    }
}
