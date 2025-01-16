package server;

import utils.AES;
import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private AES aes;

    public ClientHandler(Socket socket, AES aes) throws IOException {
        this.clientSocket = socket;
        this.aes = aes;
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                String encryptedMessage = in.readUTF();
                String decryptedMessage = aes.decrypt(encryptedMessage);
                System.out.println("Received: " + decryptedMessage);
                // Handle sending and receiving files
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
