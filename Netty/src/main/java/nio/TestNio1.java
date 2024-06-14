package nio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 简单写一个NIO程序
 */
public class TestNio1 {


    public static void main(String[] args) throws IOException {

        // 1.创建channel泳道 FileChannel
        FileChannel channel = new FileInputStream("/Users/wl/Documents/code/Study-Note/Netty/src/main/java/a.txt").getChannel();
        // 创建缓存区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        while (true) {
            //  把通道内的文件，写入缓冲区
            int read = channel.read(buffer);
            if (read == -1) break;
            //程序读取buffer内容，需要设置为读模式
            buffer.flip();
            //循环读取缓存区的数据
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            // 设置buffer的写模式
            buffer.clear();
        }
    }
}
