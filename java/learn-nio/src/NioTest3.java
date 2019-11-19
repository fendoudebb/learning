import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        byte[] messages = "hello nio".getBytes();
        for (byte message : messages) {
            buffer.put(message);
        }
        buffer.flip();
        fileChannel.write(buffer);
        fileOutputStream.close();
    }
}
