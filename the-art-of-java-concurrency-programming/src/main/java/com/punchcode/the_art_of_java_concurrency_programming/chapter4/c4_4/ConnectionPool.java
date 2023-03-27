package com.punchcode.the_art_of_java_concurrency_programming.chapter4.c4_4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author: Harry Zhang
 * @since: 27/Mar/2023
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    /**
     * @param initialSize 连接池初始连接数量
     */
    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 连接释放后需要进行通知, 这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 获取连接. 在mills内无法获取到连接, 返回null
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            // 完全超时
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

    public static class ConnectionDriver {
        static class ConnectionHandler implements InvocationHandler {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("commit")) {
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            return null;
        }
    }

        // 创建一个Connection的代理, 在commit时休眠100毫秒
        public static final Connection createConnection() {
            return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
        }
    }
}