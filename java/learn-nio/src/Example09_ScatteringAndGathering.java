import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * zbj: created on 2021/3/10 20:45.
 */
public class Example09_ScatteringAndGathering {

    // Scattering: 分散：将数据写入到 buffer 时，可以采用 buffer 数组，依次写入
    // Gathering: 聚集：从 buffer 读取时，可以采用 buffer 数组，依次读
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        // 绑定端口到 socket 并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        // 创建 buffer 数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等待客户端的连接（使用telnet连接）
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 假设从客户端接收8个直接
        int messageLength = 8;// 根据buffer数组分配的 5+3

        while (true) {
            int byteRead = 0;

            while (byteRead < messageLength) {
                long r = socketChannel.read(byteBuffers);
                byteRead += r;//累计读取到的字节数
                System.out.println("byteRead = " + byteRead);

                Stream.of(byteBuffers)
                        .map(byteBuffer -> "position=" + byteBuffer.position() + ", limit=" + byteBuffer.limit())
                        .forEach(System.out::println);
            }
            // 将所有buffer进行flip
            Arrays.asList(byteBuffers).forEach(Buffer::flip);

            // 将数据读出回显给客户端
            long byteWrite = 0;

            while (byteWrite < messageLength) {
                long w = socketChannel.write(byteBuffers);
                byteWrite += w;
            }

            // 将所有buffer进行clear 复位
            Arrays.asList(byteBuffers).forEach(Buffer::clear);
            System.out.println("bytesRead=" + byteRead + ", bytesWrite=" + byteWrite + ", messageLength=" + messageLength);
        }

    }

}
