package client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.AES;
import utils.Message;

import java.io.*;
import java.net.Socket;

public class ChatClient extends Application {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    private String username;
    private AES aes;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        aes = new AES();
        connectToServer();

        // Create the main chat window
        VBox layout = new VBox(10);
        layout.getChildren().add(new Text("Welcome to the chat"));

        Scene scene = new Scene(layout, 300, 250);
        stage.setTitle("Chat Application");
        stage.setScene(scene);
        stage.show();
    }

    private void connectToServer() throws IOException {
        socket = new Socket("localhost", 12345);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        // Add encryption to the stream
        out.writeUTF("Hello from client!");
    }

    private void sendMessage(String message) throws IOException {
        String encryptedMessage = aes.encrypt(message);
        out.writeUTF(encryptedMessage);
    }

    private String receiveMessage() throws IOException {
        String encryptedMessage = in.readUTF();
        return aes.decrypt(encryptedMessage);
    }

    private void sendFile(File file) throws IOException {
        // File sending logic
    }

    private void receiveFile() throws IOException {
        // File receiving logic
    }
}
