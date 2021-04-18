import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * zbj: created on 2021/3/8 21:03.
 */
public class Example03_FileChannel02 {

    public static void main(String[] args) throws IOException {
        File file = new File("file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // 将通道的数据读入到buffer
        fileChannel.read(byteBuffer);

        // 将byteBuffer的字节数据转成string
        String str = new String(byteBuffer.array());
        System.out.println(str);
       /* byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }*/
        fileInputStream.close();
    }

}
