import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.concurrent.locks.LockSupport;

/**
 * zbj: created on 2021/3/13 11:30.
 */
public class Example11_NIOClient {

    public static void main(String[] args) throws IOException {
        // 等到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置非阻塞模式
        socketChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);

        // 连接服务器

        if (!socketChannel.connect(address)) {
            while (!socketChannel.finishConnect()) {
                System.out.println(LocalDateTime.now() + " 因为连接需要时间，客户端不会阻塞，可以做其他工作...");
            }
        }

        // 如果连接成功，就发送数据
        String str = "你好 nio";

        // 包裹一个字节数组到 byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());

        // 发送数据，即：将 buffer 中的数据写入 channel
        socketChannel.write(byteBuffer);
        LockSupport.park();
    }

}
