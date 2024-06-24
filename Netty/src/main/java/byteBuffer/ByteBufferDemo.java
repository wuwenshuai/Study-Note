package byteBuffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

    public static void main(String[] args) {


        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println("capacity: " + buffer.capacity());  // 10
        System.out.println("limit: " + buffer.limit());  // 10
        System.out.println("position: " + buffer.position()); // 0

       buffer.put(new byte[]{'q','b','c'});
        System.out.println("capacity: " + buffer.capacity());  // 10
        System.out.println("limit: " + buffer.limit());  // 10
        System.out.println("position: " + buffer.position()); // 3
        System.out.println();

        buffer.flip();// 切换成读模式

        System.out.println("capacity: " + buffer.capacity());  // 10
        System.out.println("limit: " + buffer.limit());  // 3
        System.out.println("position: " + buffer.position()); // 0


        System.out.println();

        //变成写模式
        buffer.clear();
        System.out.println("capacity: " + buffer.capacity());  // 10
        System.out.println("limit: " + buffer.limit());  // 10
        System.out.println("position: " + buffer.position()); // 0



    }
}
