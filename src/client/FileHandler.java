package client;

import java.io.*;

public class FileHandler {
    public static void sendFile(DataOutputStream out, File file) throws IOException {
        long fileSize = file.length();
        out.writeLong(fileSize);
        FileInputStream fileInput = new FileInputStream(file);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fileInput.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        fileInput.close();
    }

    public static void receiveFile(DataInputStream in, File destination) throws IOException {
        long fileSize = in.readLong();
        FileOutputStream fileOutput = new FileOutputStream(destination);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while (fileSize > 0 && (bytesRead = in.read(buffer)) != -1) {
            fileOutput.write(buffer, 0, bytesRead);
            fileSize -= bytesRead;
        }
        fileOutput.close();
    }
}
