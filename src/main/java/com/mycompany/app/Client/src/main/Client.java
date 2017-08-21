package com.mycompany.app.Client.src.main;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Client Program
 */
public class Client {

    private static final int port = 9090;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting Client for the date service");

        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n" +
                        "running the date service on port " + port);
        Socket clientSocket = null;
        try {
            clientSocket = new Socket(serverAddress, port);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String answerFromServer = input.readLine();
            JOptionPane.showMessageDialog(null, answerFromServer);
            System.out.println("Response from the server: " + answerFromServer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}