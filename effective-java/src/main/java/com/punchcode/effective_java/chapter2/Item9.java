package com.punchcode.effective_java.chapter2;

import java.io.*;

/**
 * Item 9: Prefer try-with-resources to try-finally
 * @author huanruiz
 * @since 2021/11/15
 */
public class Item9 {

    private static final int BUFFER_SIZE = 100;

    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        } finally {
            // finally中的exception覆盖try中的IllegalArgumentException(Suppressed Exception)
            throw new NullPointerException();
        }
    }

    /**
     * 单resource
     */
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /**
     * 多resource
     */
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    /**
     * try-with-resource同样可以try-catch
     */
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
}
