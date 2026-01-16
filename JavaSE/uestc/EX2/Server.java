package uestc.EX2;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT=1234;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try(ServerSocket serversocket=new ServerSocket(PORT)) {
            while(true)
            {
                Socket clientSocket=serversocket.accept();
                System.out.println("新用户连接"+clientSocket);
                ClientHandler clientHandler=new ClientHandler(clientSocket);
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private String clientName;

        public ClientHandler(Socket socket)
        {
            this.clientSocket=socket;
            try {
                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out=new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                clientName=in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message=clientName+"加入聊天室";
            System.out.println(message);
            broadcast(message);
        }

        public void sendMessage(String message)
        {
            out.println(message);
        }
    }

    private static void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        String message=clientHandler+"离开聊天室";
        broadcast(message);
        System.out.println(message);
    }

}


