package reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class ReactBossServer {

    private static final Logger log = LoggerFactory.getLogger(ReactBossServer.class);


    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8000));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // Worker worker = new Worker("read-1");
        // 模拟线程迟
        Worker[] workers = new Worker[2];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("read-" + i);
        }
        AtomicInteger index = new AtomicInteger(0);
        while (true) {
            selector.select();
            log.info("0000000000");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey scKey = iterator.next();
                iterator.remove();
                if (scKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 交给worke处理
                   // socketChannel.register(selector, SelectionKey.OP_READ);
                    // hash 取模
                   // Worker worker = workers[Math.abs(socketChannel.hashCode() % workers.length)];
                    workers[index.getAndIncrement()%workers.length].register(socketChannel);
                   // worker.register(socketChannel);
                    log.info("boss work register");
                }
            }
        }

    }
}
