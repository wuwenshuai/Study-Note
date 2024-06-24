package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class MyServer2 {

    //引入Seletor循环监听事件的方式 解决死循环空转的问题
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
            selector.select();// 等待，只有监控到了，有实际的连接或者读写操作，才会处理
            // 对应的有 有ACCEPT状态的SSC 和 READ WRITE状态的 SC 存起来
            // SelectionsKeys HashSet
            System.out.println("-----------------");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //用完之后 就要把他从SelectedKeys集合中删除掉。问题？ ServerScoketChannel---SelectedKeys删除 ，后续 SSC建立新的连接？
                iterator.remove();
                if (key.isAcceptable()) {
                    //ServerSocketChannel 负责建立链接
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    SelectionKey scKey = sc.register(selector, 0, null);
                    scKey.interestOps(SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // SocketChannel 负责读写
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(5);
                    int read = channel.read(buffer);
                    if (read == -1) {
                        key.cancel();
                    } else {
                        buffer.flip();
                        System.out.println();
                        System.out.println("Charset.defaultCharset().decode(buffer).toString() = " + Charset.defaultCharset().decode(buffer).toString());
                    }
                }


            }
        }

    }
}
