
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

/**
 * zbj: created on 2021/3/13 10:22.
 */
public class Example10_NIOServer {

    public static void main(String[] args) throws IOException {

        // 创建 ServerSocketChannel 对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 监听 8888 端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));

        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 得到一个 selector 对象
        Selector selector = Selector.open();

        // 把 serverSocketChannel 注册到 selector 关心的事件 OP_ACCEPT 连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("selection key count#" + selector.keys().size());

        // 循环等待客户端连接
        while (true) {
            // 等待1秒，如果没有事件发生，continue
            if (selector.select(5000) == 0) { // 没有事件发生
                System.out.println(LocalDateTime.now() + " 服务器等待了5秒，无连接");
                continue;
            }

            // 如果返回 > 0, 获取到相关的 selectionKeys 集合
            // 1. 如果返回 > 0 ,表示已经获取到关注的事件
            // 2. selector.selectedKeys() 返回关注事件的集合
            // selectionKeys 可反向获取 channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 根据 key 对应的通道发生的事件做相应的处理
                if (selectionKey.isAcceptable()) {// 如果是 OP_ACCEPT, 有新的客户端连接
                    // 给该客户端生成一个 SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 不设置为非阻塞模式会抛出 java.nio.channels.IllegalBlockingModeException
                    socketChannel.configureBlocking(false);
                    // 将 socketChannel 同样注册到 Selector 上, 关注事件为 OP_READ, 同时给 socketChannel 关联一个 buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println(LocalDateTime.now() + " 客户端连接成功 生成一个 socketChannel#" + socketChannel);
                    System.out.println("register selection key count#" + selector.keys().size());
                } else if (selectionKey.isReadable()) { // 如果是 OP_READ
                    // 通过 key 反向获取到对应 channel
                    // SelectableChannel channel = selectionKey.channel();
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    // 获取到该 channel 关联的 buffer
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    try {
                        channel.read(buffer);

                        System.out.println(LocalDateTime.now() + " from Client#" + new String(buffer.array()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        selectionKey.cancel();
                        channel.close();
                    }
                }

                // 手动从集合中移除当前的 selectionKey，防止重复操作
                iterator.remove();
            }
        }
    }

}
