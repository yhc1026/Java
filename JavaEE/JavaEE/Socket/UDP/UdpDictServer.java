package bit_courseJAVA.JavaEE.Socket.UDP;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer {
    private HashMap<String,String> dict=new HashMap<String,String>();
    public UdpDictServer(int port) throws SocketException {
        super(port);
        dict.put("hello","你好");
        dict.put("love you","爱你");
    }

    @Override
    public String process(String request){
        return dict.getOrDefault(request,"no found");
    }

    public static void main(String[] args) throws SocketException, IOException {
        UdpDictServer dictServer = new UdpDictServer(9090);
        dictServer.start();
    }
}
