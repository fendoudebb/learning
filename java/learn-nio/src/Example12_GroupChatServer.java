import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * zbj: created on 2021/3/13 19:00.
 */
public class Example12_GroupChatServer {

    // 定义
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 8888;

    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public Example12_GroupChatServer() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        System.out.println(LocalDateTime.now() + " 服务监听线程 id#" + Thread.currentThread().getName());
        try {
            while (true) {
                System.out.println(LocalDateTime.now() + " before select");
                int count = selector.select(2000);
                System.out.println(LocalDateTime.now() + " after select, count#" + count);
                if (count == 0) {
                    continue;
                }
                System.out.println(LocalDateTime.now() + " count>0, count#" + count);
                try {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();

                    Iterator<SelectionKey> iterator = selectionKeys.iterator();

                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()) {
                            SocketChannel socketChannel = listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            // 给出提示
                            System.out.println(socketChannel.getRemoteAddress() + " 上线了");
                        } else if (selectionKey.isReadable()) {
                            sendInfoToOthers(selectionKey);
                        }
                        iterator.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void sendInfoToOthers(SelectionKey selectionKey) {
        System.out.println(LocalDateTime.now() + " 转发数据线程 id#" + Thread.currentThread().getName());
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int r = socketChannel.read(byteBuffer);
            if (r > 0) {
                String msg = new String(byteBuffer.array());
                System.out.println("From 客户端#" + msg);

                // 给其他客户端发消息，排除自己
                for (SelectionKey key : selector.keys()) {
                    // ServerSocketChannelImpl cannot be cast to java.nio.channels.SocketChannel
                    // SocketChannel targetChannel = (SocketChannel) key.channel();

                    Channel channel = key.channel();

                    // 排除自己
                    if (channel instanceof SocketChannel && channel != socketChannel) {
                        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                        SocketChannel sc = (SocketChannel) channel;
                        sc.write(buffer);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // 取消注册
            selectionKey.cancel();
            try {
                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Example12_GroupChatServer server = new Example12_GroupChatServer();
//        server.listen();

        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<?> aaaaaaaaaaaaa = pool.submit(() -> {
            System.out.println("aaaaaaaaaaaaa");
        });
        Object o = aaaaaaaaaaaaa.get();
        System.out.println(o);

    }

}
