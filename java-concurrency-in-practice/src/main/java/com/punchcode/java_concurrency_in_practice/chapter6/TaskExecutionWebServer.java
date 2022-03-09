package com.punchcode.java_concurrency_in_practice.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author huanruiz
 * @since 2022/3/8
 */
public class TaskExecutionWebServer {
    
    private static final int N_THREADS = 100;
    
    private static final Executor exec = Executors.newFixedThreadPool(N_THREADS);
    
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
               @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }
    
    private static void handleRequest(Socket connection) {
    
    }
}
