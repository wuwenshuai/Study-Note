package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client {


    public static void main(String[] args) throws IOException {



        SocketChannel socketChannel = SocketChannel.open();
        // 设置服务端的监听端口
        socketChannel.connect(new InetSocketAddress(8000));
        System.out.println("-----------------------");

        socketChannel.write(Charset.defaultCharset().encode("aaaaaa\n"));
        System.out.println("write");
//        while (true) {
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            int read = socketChannel.read(buffer);
//            System.out.println("read:"+read);
//            buffer.clear();
//        }

    }
}
