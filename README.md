# Chat Application with File Sharing

A real-time chat application built with Java Sockets, JavaFX, and AES encryption, offering secure communication and file sharing. This application supports one-on-one messaging, group chats, and the ability to send and receive files.

---

## **Features**

- **Real-Time Messaging**: Instant text communication between users with support for one-on-one and group chats.
- **File Sharing**: Secure transfer of files between users, including images, documents, and other media.
- **AES Encryption**: All messages and files are encrypted using AES (Advanced Encryption Standard) to ensure data privacy and integrity.
- **JavaFX GUI**: A clean, modern, and user-friendly graphical interface designed using JavaFX.
- **Multi-Client Support**: The server can handle multiple clients at the same time, allowing several users to chat simultaneously.

---

## **Technologies Used**

- **Java**: The core programming language for both the client and server applications.
- **JavaFX**: For the graphical user interface (GUI) of the chat client.
- **AES Encryption**: For secure transmission of messages and files between clients.
- **Java Sockets**: For real-time communication between the client and server.
- **Maven**: For managing project dependencies and building the application (optional if you are using Maven).

---



## **How to Use**

### **For Clients:**

1. **Login**: Enter your username when prompted to connect to the server.
2. **Chat**: Type messages into the input field and hit Enter to send.
3. **File Sharing**: Choose a file from your local machine and send it through the chat interface. (File handling can be extended in the GUI as per the project’s needs.)
4. **Group Chats**: Send messages to multiple users (you can extend this feature in the future to allow group management).

### **For Admin (Server):**

The server listens for multiple client connections, decrypts incoming messages, and sends them back to the connected clients. It ensures all communications are secure and handled properly.

---

## **File Structure**

Here is an overview of the project's file and folder structure:

```
ChatApp/
│
├── src/
│   ├── client/
│   │   ├── ChatClient.java          # Client application entry point
│   │   ├── ChatClientGUI.java       # GUI of the chat application
│   │   └── FileHandler.java         # File transfer logic
│   │
│   ├── server/
│   │   ├── ChatServer.java          # Server-side application to handle multiple clients
│   │   └── ClientHandler.java       # Handles individual client connections
│   │
│   ├── utils/
│   │   ├── AES.java                 # AES encryption utility
│   │   └── Message.java             # Helper class to represent messages
│
└── pom.xml                          # Maven project configuration (optional)
```

---

## **Security**

This chat application ensures secure messaging and file sharing with the use of **AES encryption**. All messages are encrypted before being sent over the network, and files are transferred securely to avoid unauthorized access.

### **AES Encryption**

- The AES encryption algorithm is used to encrypt both chat messages and file content before sending it over the network.
- This prevents third parties from reading the communication, ensuring privacy and confidentiality.


