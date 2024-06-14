package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class MyServer1 {

    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置服务端的监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(20);
        List<SocketChannel> channelList = new ArrayList<>();

        // 接受client的连接
        while (true) {
            // SocketChannel 代表服务端与client连接的一个通道
            System.out.println("等待客户端连接...");
            SocketChannel socketChannel = serverSocketChannel.accept(); // 阻塞 程序等待client
            System.out.println("客户端连接成功");
            channelList.add(socketChannel);
            // client与服务端通讯过程
            for (SocketChannel channel : channelList) {
                System.out.println("开始读取数据...");
                channel.read(buffer);  // 阻塞 对应的IO通讯阻塞
                buffer.flip();  
                System.out.println("读取到的数据是：" + new String(buffer.array()));
                buffer.clear(); // 切换写模式
                System.out.println("读取数据结束");
            }

        }


    }
}
