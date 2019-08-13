package learn.netty.demo.example01_http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    public boolean isSharable() {
        boolean sharable = super.isSharable();
        System.out.println("TestHttpServerHandler.isSharable#" + sharable);
        return sharable;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.handlerAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.channelActive");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("TestHttpServerHandler.channelRead, msg#" + msg.getClass());
        super.channelRead(ctx, msg);
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        System.out.println("TestHttpServerHandler.acceptInboundMessage");
        return super.acceptInboundMessage(msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        /*
        八月 12, 2019 6:04:15 下午 io.netty.channel.DefaultChannelPipeline onUnhandledInboundException
        警告: An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.
        java.io.IOException: Connection reset by peer
        at sun.nio.ch.SocketDispatcher.read0(Native Method)
        at sun.nio.ch.SocketDispatcher.read(SocketDispatcher.java:43)
        at sun.nio.ch.IOUtil.readIntoNativeBuffer(IOUtil.java:223)
        at sun.nio.ch.IOUtil.read(IOUtil.java:192)
        at sun.nio.ch.SocketChannelImpl.read(SocketChannelImpl.java:380)
        at io.netty.buffer.PooledByteBuf.setBytes(PooledByteBuf.java:247)
        at io.netty.buffer.AbstractByteBuf.writeBytes(AbstractByteBuf.java:1140)
        at io.netty.channel.socket.nio.NioSocketChannel.doReadBytes(NioSocketChannel.java:347)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:148)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:697)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:632)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:549)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:511)
        at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:918)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.lang.Thread.run(Thread.java:748)

        解决方法：添加判断if (msg instanceof HttpRequest) {}
        */

        System.out.println("TestHttpServerHandler.channelRead0, remoteAddress#" + ctx.channel().remoteAddress() + ", msg#" + msg.getClass());

        if (msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            System.out.println("请求方法：" + httpRequest.method().name());
            System.out.println("请求路径：" + httpRequest.uri());
            if ("/favicon.ico".equals(httpRequest.uri())) {
                System.out.println("请求favicon.ico");
                return;
            }

            ByteBuf content = Unpooled.copiedBuffer("Hello World!", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN);
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.channelReadComplete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.channelUnregistered");
        super.channelUnregistered(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.handlerRemoved");
        super.handlerRemoved(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("TestHttpServerHandler.userEventTriggered, evt#" + evt.getClass());
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHttpServerHandler.channelWritabilityChanged");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("TestHttpServerHandler.exceptionCaught#" + cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println("TestHttpServerHandler.ensureNotSharable");
        super.ensureNotSharable();
    }

}
