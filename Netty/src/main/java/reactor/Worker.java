package reactor;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Worker implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(Worker.class);
    private Selector selector;
    private Thread thread;
    private final String name;

    private ConcurrentLinkedDeque<Runnable> runnables = new ConcurrentLinkedDeque<>();

    private boolean isCreated = false;

    public Worker(String name) throws IOException {
        this.name = name;
        this.thread = new Thread(this, this.name);
        thread.start();
        selector = Selector.open();
    }

    public void register(SocketChannel socketChannel) throws IOException {

        runnables.add(() -> {
            try {
                socketChannel.register(selector, SelectionKey.OP_READ);
            } catch (ClosedChannelException e) {
                throw new RuntimeException(e);
            }
        });

        selector.wakeup();
    }


    @Override
    public void run() {

        log.debug("run------");
        while (true) {
            try {
                selector.select();
                Runnable poll = runnables.poll();
                if (poll != null) {
                    poll.run();
                }
                Iterator<SelectionKey> iterator =
                        selector.selectedKeys().iterator();
                if (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(20);
                        sc.read(buffer);
                        buffer.flip();
                        String result = Charset.defaultCharset().decode(buffer).toString();
                        log.debug("result:" + result);
                    } else if (key.isWritable()) {
                        System.out.println("writable");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
