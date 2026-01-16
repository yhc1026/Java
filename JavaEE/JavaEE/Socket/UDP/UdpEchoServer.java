//DatagramSocket: 可以看作是通过这个来操作网卡
//DatagramPacket: 可以看作是一个数据包（packet）

package bit_courseJAVA.JavaEE.Socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpEchoServer {

    private DatagramSocket socket=null;

    public UdpEchoServer (int port) throws SocketException{
        //指定一个固定端口号，让服务器使用
        socket=new DatagramSocket(port);
    }

    public void start() throws IOException {
        //启动服务器
        System.out.println("start server");
        while (true){
            //循环一次，就处理一次请求
            //1.读取请求并解析
            //DatagramPacket是一个UDP数据报，包括报头和载荷。此处传入的字节数组，保存UDP的载荷部分
            DatagramPacket requestPacket=new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //把读取的二进制数据转换为字符串，只构造有效部分
            String request=new String(requestPacket.getData(),0,requestPacket.getLength());
            //2.根据请求计算相应，此处是回显服务器，省略
            String response =process(request);
            //3.把相应返回给服务器
            //根据response构造Datagrampacket
            DatagramPacket responsePacket=new DatagramPacket(
                    response.getBytes(StandardCharsets.UTF_8),
                    response.getBytes().length,
                    requestPacket.getAddress(),
                    requestPacket.getPort());
            //指定目的ip和目的端口
            socket.send(responsePacket);
            System.out.printf("[%s:%d req:%s, resp: %s\n", requestPacket.getAddress().toString(), requestPacket.getPort(), request,response);
        }
    }

    public String process(String request){
        request="you typed "+request;
        return request;
    }

    public static void main(String[] args) throws IOException{
        UdpEchoServer server=new UdpEchoServer(9090);
        server.start();
    }
}
