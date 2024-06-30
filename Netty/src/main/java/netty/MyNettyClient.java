package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class MyNettyClient {

    private static final Logger log = LoggerFactory.getLogger(MyNettyClient.class);
    public static void main(String[] args) throws InterruptedException {

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.channel(NioSocketChannel.class);
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup(3);
        bootstrap.group(eventLoopGroup);

        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new LoggingHandler());
                ch.pipeline().addLast(new StringEncoder());
            }
        });

        //connect 用一个新的线程，用于连接
        ChannelFuture connect = bootstrap.connect(new InetSocketAddress(8000));
       // connect.sync(); //阻塞在这,链接建立就会走到后面代码,异步阻塞

        //operationComplete 添加回调的方式等同上面操作，这一句话不是在主线程上面执行的，是 bootstrap.connect进行创建的
        connect.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                log.debug("listen--------------");
                //创建新线程进行写操作
                Channel channel = connect.channel();
                channel.writeAndFlush("hello carry");
               // ChannelFuture close = channel.close();
//                close.addListener(new ChannelFutureListener() {
//                    @Override
//                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                      log.debug("channel close-----");
//                    }
//                });
            }
        });

        //优雅关闭
     //   eventLoopGroup.shutdownGracefully();
    }
}
