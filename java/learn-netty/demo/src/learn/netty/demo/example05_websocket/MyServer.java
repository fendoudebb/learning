package learn.netty.demo.example05_websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MyServer {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        workerGroup.scheduleAtFixedRate(
                () -> {
                    System.out.println("定时任务开启");
                    TextWebSocketFrameHandler.channelGroup.writeAndFlush(new TextWebSocketFrame("定时任务：" + LocalDateTime.now()));
                },
                3,
                1,
                TimeUnit.SECONDS);

        /*new Thread(() -> {
            while (true) {
                try {
                    TextWebSocketFrameHandler.channelGroup.writeAndFlush(new TextWebSocketFrame("定时任务：" + LocalDateTime.now()));
//                    TextWebSocketFrameHandler.channelGroup.writeAndFlush(new PingWebSocketFrame());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

        try {
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new WebSocketChannelServerInitializer())
                    .bind(8899)
                    .sync()
                    .channel()
                    .closeFuture()
                    .sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
