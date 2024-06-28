package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class MyServer5 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8000));
        serverSocketChannel.configureBlocking(false);// selector 只有在非阻塞的情况下才可以使用   解决1accept的阻塞
        //引入监管者：accept read write
        Selector selector = Selector.open(); // 单利设计模式
        // serverSocketChannel注册到selector中 被selector监管
        SelectionKey selectionKey = serverSocketChannel.register(selector, 0, null);
        // selector监控ssc accept.注册事件
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);
        System.out.println("server start");

        while (true) {
            selector.select();

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            if (iterator.hasNext()) {
                SelectionKey scKeys = iterator.next();
                iterator.remove();
                if (scKeys.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);
                    SelectionKey sk = socketChannel.register(selector, SelectionKey.OP_READ);

                    // 准备数据
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < 1000000; i++) {
                        stringBuffer.append("a");
                    }

                    // Buffer 存储数据
                    ByteBuffer buffer = Charset.defaultCharset().encode(stringBuffer.toString());
                   // while (buffer.hasRemaining()) {
                        int write = socketChannel.write(buffer);
                        System.out.println("write="+write);
                        if (buffer.hasRemaining()) {
                            // 没有写完
                           sk.interestOps(sk.interestOps() + SelectionKey.OP_WRITE);
                            //  把buffer传下去
                            sk.attach(buffer);
                            int write2 = socketChannel.write(buffer);
                            System.out.println("write2="+write2);
                        }
                   // }

                } else if (scKeys.isWritable()) {
                    // 会有循环的含义
                    SocketChannel socketChannel = (SocketChannel) scKeys.channel();
                    // 获取buffer
                    ByteBuffer buffer = (ByteBuffer) scKeys.attachment();
                    // 写操作
                    int write = socketChannel.write(buffer);
                    System.out.println("write3="+write);
                    if (!buffer.hasRemaining()) {
                        scKeys.attach(null);
                        scKeys.interestOps(scKeys.interestOps() - SelectionKey.OP_WRITE);
                    }
                }

            }

        }




    }
}
