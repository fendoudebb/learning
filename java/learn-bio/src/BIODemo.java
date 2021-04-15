import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * zbj: created on 2021/3/7 11:53.
 */
public class BIODemo {

    public static void main(String[] args) throws IOException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("server start");

        while (true) {
            // 监听，等待客户端连接
            System.out.println("等待客户端连接");
            Socket socket = serverSocket.accept();
            System.out.println("connected Thread Id#" + Thread.currentThread().getId() + ", Thread Name#" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];

            cachedThreadPool.execute(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    while (true) {
                        System.out.println("waiting read Thread Id#" + Thread.currentThread().getId() + ", Thread Name#" + Thread.currentThread().getName());
                        int read = inputStream.read(bytes);
                        if (read != -1) {
                            System.out.println("receive Thread Id#" + Thread.currentThread().getId() + ", Thread Name#" + Thread.currentThread().getName() + ", message#" + new String(bytes, 0, read));
                        } else {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
