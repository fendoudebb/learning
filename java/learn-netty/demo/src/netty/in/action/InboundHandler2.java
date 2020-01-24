package netty.in.action;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class InboundHandler2 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InboundHandler2: channelRead");
//        super.channelRead(ctx, msg);

        ByteBuf byteBuf= (ByteBuf) msg;
        System.out.println("InboundHandler2, refCnt: " + byteBuf.refCnt());
        System.out.println("inbound2  === "+byteBuf.toString(CharsetUtil.UTF_8));
//ctx.fireChannelRead(Unpooled.copiedBuffer("inbound2===>>>>"+byteBuf.toString(CharsetUtil.UTF_8),CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("inbound2===>>>>"+byteBuf.toString(CharsetUtil.UTF_8),CharsetUtil.UTF_8));

        System.out.println("InboundHandler2, ReferenceCountUtil.refCnt: " + ReferenceCountUtil.refCnt(byteBuf));
        ReferenceCountUtil.release(byteBuf);
        System.out.println("InboundHandler2, refCnt: " + byteBuf.refCnt());

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        System.out.println("InboundHandler2: channelReadComplete");
//        ctx.flush();
    }

}
