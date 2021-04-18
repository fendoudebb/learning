import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * zbj: created on 2021/3/13 19:25.
 */
public class Example13_GroupChatClient {

    public static final String HOST = "127.0.0.1";

    public static final int PORT = 8888;

    private Selector selector;

    private SocketChannel socketChannel;

    private String username;

    public Example13_GroupChatClient() {
        try {
            selector = Selector.open();

            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);

            socketChannel.register(selector, SelectionKey.OP_READ);

            username = socketChannel.getLocalAddress().toString().substring(1);

            System.out.println("客户端#" + username + "准备好了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendInfo(String info) throws IOException {
        info = username + ": " + info;
        socketChannel.write(ByteBuffer.wrap(info.getBytes()));
    }

    public void readInfo() throws IOException {
        int readEvent = selector.select();
        if (readEvent > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer);
                    String msg = new String(byteBuffer.array());
                    System.out.println(msg);
                }
                iterator.remove();
            }
        } else {
            System.out.println("无可读数据");
        }

    }



    public static void main(String[] args) throws IOException {
        Example13_GroupChatClient client = new Example13_GroupChatClient();
        new Thread(() -> {
            while (true) {
                try {
                    client.readInfo();
                    System.out.println("111111111111111111");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            client.sendInfo(msg);
        }
    }

}
