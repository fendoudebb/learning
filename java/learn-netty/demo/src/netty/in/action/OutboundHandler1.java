package netty.in.action;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

public class OutboundHandler1 extends ChannelOutboundHandlerAdapter {

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        super.read(ctx);
        System.out.println("OutboundHandler1: read");
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//        super.write(ctx, msg, promise);
        System.out.println("OutboundHandler1: write");

        ByteBuf data= (ByteBuf) msg;

        System.out.println("Outbound1 "+data.toString(CharsetUtil.UTF_8));
        ctx.write(Unpooled.copiedBuffer("outbound1===>>>>>"+data.toString(CharsetUtil.UTF_8),CharsetUtil.UTF_8));
//        ctx.flush();
        Thread.sleep(2000);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        super.flush(ctx);
        System.out.println("OutboundHandler1: flush");
    }
}
