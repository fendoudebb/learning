package learn.netty.demo.example03_socket_chat_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyChatClient {

    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            Channel channel = bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer())
                    .connect("localhost", 8899)
                    .sync()
                    .channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                channel.writeAndFlush(br.readLine() + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
