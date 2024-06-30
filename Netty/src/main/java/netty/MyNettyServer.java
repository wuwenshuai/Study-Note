package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class MyNettyServer {

    private static final Logger log = LoggerFactory.getLogger(MyNettyServer.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);


        NioEventLoopGroup bossEventGroup = new NioEventLoopGroup(1);

        NioEventLoopGroup workerEventGroup = new NioEventLoopGroup(3);


        // 获得default
        DefaultEventLoopGroup  defaultEventLoopGroup = new DefaultEventLoopGroup(2);


        // 创建了一组线程，通过死循环 监控accept read 事件
        serverBootstrap.group(bossEventGroup,workerEventGroup);


        //接收数据和写数据，都需要handler去处理
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //读写 Channel
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
               pipeline.addLast(new StringDecoder());

               //  ChannelInboundHandlerAdapter:读数据handler
                pipeline.addLast("handler2", new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("handler2 ctx ... {} ", msg);
                        super.channelRead(ctx, msg);
                    }
                });

                pipeline.addLast("handler3", new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("handler3");
                        //super.channelRead(ctx, msg);
                        ch.writeAndFlush("hello  suns"); //全局查找输出的OutboundHandler ，依次运行
                        // ctx.writeAndFlush("hello xiaojr");  // c从当前的Handler，往前查找，没有输出的OutboundHandler
                    }
                });

                pipeline.addLast("hadler4", new ChannelOutboundHandlerAdapter() {
                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                        log.debug("handler4");
                        super.write(ctx, msg, promise);
                    }
                });
                pipeline.addLast("hadler5", new ChannelOutboundHandlerAdapter() {
                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                        log.debug("handler5");
                        super.write(ctx, msg, promise);
                    }
                });

                pipeline.addLast("hadler6", new ChannelOutboundHandlerAdapter() {
                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                        log.debug("handler6");
                        super.write(ctx, msg, promise);
                    }
                });

            }
        });

        serverBootstrap.bind(8000);
    }
}
