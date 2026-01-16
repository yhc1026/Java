package uestc.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatRoomServer {
    private static final int PORT = 1234;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("在端口 " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("新用户已连接");

                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMessage(String message, ClientHandler excludeClient) {
        for (ClientHandler client : clients) {
            if (client != excludeClient) {
                client.sendMessage(message);
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private String nickname;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                nickname = in.readLine();
                broadcastMessage(nickname + " 加入聊天.", this);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(nickname + ": " + message);
                    broadcastMessage(nickname + ": " + message, this);
                }
            } catch (IOException e) {
                System.out.println("错误的用户: " + e.getMessage());
            } finally {
                try {
                    clients.remove(this);
                    broadcastMessage(nickname + " 离开聊天", this);
                    socket.close();
                } catch (IOException e) {
                    System.out.println("错误: " + e.getMessage());
                }
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}
