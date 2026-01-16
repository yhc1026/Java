package bit_courseJAVA.JavaEE.Socket.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoClient {
    private Socket socket = null;

    public TCPEchoClient(String serverIP, int serverPort) throws IOException {
        socket = new Socket(serverIP, serverPort);
    }

    public void start() throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner sc = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        System.out.println("start client");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //从控制台获取用户输入
            String request = scanner.nextLine();
            //利用PrintWriter将输入放入输出字节流的发送缓冲区
            out.println(request);
            //将发送缓冲区中的东西冲入字节流
            out.flush();
            //通过scanner从输入字节流中获取server传回的信息
            String response=sc.nextLine();
            //打印到控制台
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        TCPEchoClient client=new TCPEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
