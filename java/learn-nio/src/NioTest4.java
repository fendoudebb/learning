import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("README.md");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        while (true) {
            //注释掉这行代码会无限写内容，因为flip()后，position又回到起始点，继续写之前写入的内容。
            //clear()将重置position, limit等
            buffer.clear();
            int read = inputChannel.read(buffer);
            System.out.println("read: " + read);
            if (read == -1) {
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
        }
        inputChannel.close();
        outputChannel.close();
    }

}
