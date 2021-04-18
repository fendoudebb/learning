import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * zbj: created on 2021/3/8 21:03.
 */
public class Example05_FileChannel04 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");

        FileOutputStream fileOutputStream = new FileOutputStream("3.txt");

        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel dstChannel = fileOutputStream.getChannel();

        // 使用 transferFrom
        dstChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

        sourceChannel.close();
        dstChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

}
