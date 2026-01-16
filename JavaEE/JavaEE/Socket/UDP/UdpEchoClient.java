//DatagramSocket: 可以看作是通过这个来操作网卡
//DatagramPacket: 可以看作是一个数据包（packet）

package bit_courseJAVA.JavaEE.Socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket=null;
    private String serverIP;
    private int serverPort;

    //客户端需要指定访问服务器的地址（IP+端口号）
    public UdpEchoClient(String serverIP, int serverPort) throws IOException {
        this.serverIP=serverIP;
        this.serverPort=serverPort;
        socket=new DatagramSocket();
    }

    public void start() throws IOException {
        while(true){
            //先从控制台读取一个内容
            System.out.println("message:");
            Scanner scanner=new Scanner(System.in);
            String request=scanner.nextLine();
            //把内容发给服务器
            //构造datagrampacket,构造载荷，设置IP和端口号
            DatagramPacket packet=new DatagramPacket(request.getBytes(StandardCharsets.UTF_8), request.getBytes().length, InetAddress.getByName(serverIP), serverPort);
            //发送
            socket.send(packet);
            //接受相应
            DatagramPacket responsePacket=new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            //解析接收的内容
            String response=new String(responsePacket.getData(), 0, responsePacket.getLength(), StandardCharsets.UTF_8);
            //打印接收的内容
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        //127.0.0.1为环回IP，永远表示当前主机
        UdpEchoClient client=new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
