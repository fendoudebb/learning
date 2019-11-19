import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("README.md");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        //Channel 往 Buffer 里写，所以之后要调用flip翻转
        fileChannel.read(buffer);

        //操作翻转
        buffer.flip();

        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            System.out.println(b);
            System.out.println("Character: " + (char)b);
        }
        fileInputStream.close();
    }
}
