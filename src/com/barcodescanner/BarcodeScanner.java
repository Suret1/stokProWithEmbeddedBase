package com.barcodescanner;

import com.frame.MainFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BarcodeScanner implements Runnable {

    private static Socket socket;
    private static ServerSocket serverSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader br;
    public static String barcode;

    @Override
    public void run() {

        try {

            Thread.sleep(1000);

            serverSocket = new ServerSocket(65535);

            while (true) {

                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(inputStreamReader);
                barcode = br.readLine();

                MainFrame.barcode.setText(barcode);

            }
        } catch (IOException | InterruptedException e) {

        }

    }

}
