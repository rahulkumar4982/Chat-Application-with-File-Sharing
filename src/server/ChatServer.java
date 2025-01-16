package server;

import java.io.*;
import java.net.*;
import utils.AES;

public class ChatServer {
    private ServerSocket serverSocket;
    private AES aes;

    public static void main(String[] args) throws IOException {
        new ChatServer().start();
    }

    public ChatServer() throws IOException {
        serverSocket = new ServerSocket(12345);
        aes = new AES();
    }

    public void start() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket, aes).start();
        }
    }
}
