//ServerSocket：负责接收
//Socket；负责提供服务

package bit_courseJAVA.JavaEE.Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPEchoServer {
    private ServerSocket serverSocket=null;

    public TCPEchoServer(int port) throws Exception {
        serverSocket=new ServerSocket(port);
    }

    public void start() throws Exception{
        System.out.println("Start");
        ExecutorService executor = Executors.newCachedThreadPool();
        while(true){
            //处理客户端发来的连接
            //通过读写Socket（clientSocket）来通信
            //如果没有建立连接，accept就会阻塞。在这里accept，之后创建多线程处理不同client的请求
            Socket clientSocket=serverSocket.accept();

            //使用多线程处理
//            Thread thread=new Thread(()->{
//                try {
//                    processConnection(clientSocket);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            thread.start();

            //使用线程池处理
            executor.submit(()-> {
                try {
                    processConnection(clientSocket);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public void processConnection(Socket clientSocket) throws Exception {
        System.out.println(clientSocket.getInetAddress()+":"+clientSocket.getPort());
        InputStream inputStream=clientSocket.getInputStream();
        OutputStream outputStream=clientSocket.getOutputStream();
        Scanner scanner=new Scanner(inputStream);
        PrintWriter writer=new PrintWriter(outputStream);
        while(true){
            //判断是否结束，必须读取到\n才会停止读取
            if(!scanner.hasNextLine()){
                System.out.println("offline");
                break;
            }
            //scanner读取一行
            String request=scanner.nextLine();
            //处理读取的数据
            String response=process(request);
            //用writer将处理后的返回数据写入缓冲区
            writer.println(response);
            //用flush冲入字节流
            writer.flush();
            System.out.printf("[%s:%d] req: %s, resp: %s\n", clientSocket.getInetAddress(),clientSocket.getPort(), request,response);
        }
        //在此处关闭clientSocket
        clientSocket.close();
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws Exception {
        TCPEchoServer server=new TCPEchoServer(9090);
        server.start();
    }
}
