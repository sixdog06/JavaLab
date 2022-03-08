package com.punchcode.java_concurrency_in_practice.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 串行, 性能不好, 但是能提供简单性和安全性. GUI框架用的多, 但不适合web服务器
 * @author huanruiz
 * @since 2022/3/8
 */
public class SingleThreadWebServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }
    
    private static void handleRequest(Socket connection) {
    
    }
}
