package learn.netty.demo.example03_socket_chat_demo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        //遍历所有连接的channel并发送消息
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 加入\n");

        channelGroup.add(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println(ctx.channel().remoteAddress() + " 上线");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if (channel != ch) {
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息：" + msg + System.lineSeparator());
            } else {
                ch.writeAndFlush("【自己】" + msg + System.lineSeparator());
            }
        });
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println(ctx.channel().remoteAddress() + " 下线");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 离开" + System.lineSeparator());
        //netty会自动移除改channel
//        channelGroup.remove(channel);
        System.out.println(channel.id() + " 断开，当前有有[" + channelGroup.size() + "]个channel连接");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
