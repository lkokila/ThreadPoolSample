package com.mycompany.app.Server.src.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server Program
 */
public class Server {

    private static final int numberOfThreads = 3;
    private static final int port = 9090;
    private static ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

    public static void main(String[] args) throws IOException {
        System.out.println("Starting date server");
        ServerSocket listener = new ServerSocket(port);

        try {
            while (true) {
                Socket serverSocket = listener.accept();
                executorService.submit(new ServiceRequest(serverSocket));
            }
        } finally {
            listener.close();
        }
    }

    private static class ServiceRequest implements Runnable {

        private Socket ServiceRequestSocket;

        private ServiceRequest(Socket connection) {
            this.ServiceRequestSocket = connection;
        }

        public void run() {
            try {
                System.out.println("Server Thread " + Thread.currentThread().getName() + " starting work");
                PrintWriter out = new PrintWriter(ServiceRequestSocket.getOutputStream(), true);
                out.println(new Date().toString());
                System.out.println("Server Thread " + Thread.currentThread().getName() + " finishing work");

            } catch (IOException e) {
                System.out.println("Error closing client connection");
            } finally {
                try {
                    ServiceRequestSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
