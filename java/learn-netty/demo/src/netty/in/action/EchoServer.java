package netty.in.action;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

    public static void main(String[] args) throws InterruptedException {
        EchoServer echoServer = new EchoServer();
        echoServer.start();
    }

    public void start() throws InterruptedException {
        //只new一次的话，需要加@Sharable
        EchoServerHandler handler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(8080)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

//                            ch.pipeline().addLast(handler);
                            ch.pipeline().addLast(new OutboundHandler1());
                            ch.pipeline().addLast(new OutboundHandler2());
                            ch.pipeline().addLast(new InboundHandler1());
                            ch.pipeline().addLast(new InboundHandler2());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }


    }

}
