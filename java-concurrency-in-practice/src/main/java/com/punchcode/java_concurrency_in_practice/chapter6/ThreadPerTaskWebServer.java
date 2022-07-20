package com.punchcode.java_concurrency_in_practice.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 为每个线程创建线程
 * @author huanruiz
 * @since 2022/3/8
 */
public class ThreadPerTaskWebServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                
                @Override
                public void run() {
                    handleRequest(connection);
                } };
            new Thread(task).start();
        }
    }
    
    private static void handleRequest(Socket connection) {

    }
}
