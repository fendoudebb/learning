import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * zbj: created on 2021/3/8 21:03.
 */
public class Example04_FileChannel03 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        while (true) {
            // 非常重要，否则 position = limit，一直无法跳出循环
            buffer.clear();
            int read = fileChannel01.read(buffer);
            if (read == -1) {
                //表示读完
                break;
            }
            buffer.flip();
            fileChannel02.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
