package client;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.application.Platform;

public class ChatClientGUI {
    private VBox chatLayout;
    private TextArea chatArea;
    private TextField messageInput;

    public ChatClientGUI() {
        chatLayout = new VBox(10);
        chatArea = new TextArea();
        messageInput = new TextField();

        chatLayout.getChildren().addAll(chatArea, messageInput);

        messageInput.setOnAction(event -> sendMessage());
    }

    private void sendMessage() {
        String message = messageInput.getText();
        messageInput.clear();
        
        // send message to server here
    }

    public Scene getScene() {
        return new Scene(chatLayout, 300, 250);
    }

    public void updateChatArea(String message) {
        Platform.runLater(() -> chatArea.appendText(message + "\n"));
    }
}
