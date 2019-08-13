## Channel执行流程
1. isSharable
2. handlerAdded
3. channelRegistered
4. channelActive
5. channelRead
6. acceptInboundMessage
7. channelRead0
8. channelReadComplete
9. channelInactive
10. channelUnregistered
11. handlerRemoved

其中`5`-`8`可能多次执行

## 请求示例
使用`curl localhost:8899`

```shell
TestHttpServerHandler.isSharable#false
TestHttpServerHandler.handlerAdded
TestHttpServerHandler.channelRegistered
TestHttpServerHandler.channelActive
TestHttpServerHandler.channelRead, msg#class io.netty.handler.codec.http.DefaultHttpRequest
TestHttpServerHandler.acceptInboundMessage
TestHttpServerHandler.channelRead0, remoteAddress#/0:0:0:0:0:0:0:1:56887, msg#class io.netty.handler.codec.http.DefaultHttpRequest
请求方法：GET
请求路径：/
TestHttpServerHandler.channelRead, msg#class io.netty.handler.codec.http.LastHttpContent$1
TestHttpServerHandler.acceptInboundMessage
TestHttpServerHandler.channelRead0, remoteAddress#/0:0:0:0:0:0:0:1:56887, msg#class io.netty.handler.codec.http.LastHttpContent$1
TestHttpServerHandler.channelReadComplete
TestHttpServerHandler.channelReadComplete
TestHttpServerHandler.channelInactive
TestHttpServerHandler.channelUnregistered
TestHttpServerHandler.handlerRemoved
```