package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Client {


    public static void main(String[] args) throws IOException {



        SocketChannel socketChannel = SocketChannel.open();
        // 设置服务端的监听端口
        socketChannel.connect(new InetSocketAddress(8000));
        System.out.println("-----------------------");
        socketChannel.write(ByteBuffer.wrap(new byte[]{1,2,3,4,5,6,7,8,9,10}));
    }
}
