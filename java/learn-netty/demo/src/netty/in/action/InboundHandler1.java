package netty.in.action;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class InboundHandler1 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InboundHandler1: channelRead");
//        super.channelRead(ctx, msg);
//        ctx.fireChannelRead(msg);

        ByteBuf byteBuf=(ByteBuf)msg;
        System.out.println("InboundHandler1, refCnt: " + byteBuf.refCnt());
        System.out.println("inbound1  === "+byteBuf.toString(CharsetUtil.UTF_8));
        ctx.fireChannelRead(Unpooled.copiedBuffer("inbound1===>>>>"+byteBuf.toString(CharsetUtil.UTF_8),CharsetUtil.UTF_8));
//        ctx.writeAndFlush(Unpooled.copiedBuffer("inbound1===>>>>"+byteBuf.toString(CharsetUtil.UTF_8),CharsetUtil.UTF_8));
//        ctx.fireChannelRead(msg);
        System.out.println("InboundHandler1, refCnt: " + byteBuf.refCnt());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        System.out.println("InboundHandler1: channelReadComplete");
    }
}
