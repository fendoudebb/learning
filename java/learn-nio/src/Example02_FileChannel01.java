import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * zbj: created on 2021/3/7 21:54.
 */
public class Example02_FileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello world";
        // 输出流
        FileOutputStream fileOutputStream = new FileOutputStream("file01.txt");
        // 通过 FileOutputStream 获取对应的 FileChannel
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将 str 放入 byteBuffer
        byteBuffer.put(str.getBytes());

        // 对 byteBuffer 翻转，准备从 byteBuffer写入 FileChannel
        // 如果不翻转，将从第11个索引位置处（hello world 长度为11），写到1024结束， 共1013个字节。
        byteBuffer.flip();

        // 将 byteBuffer 数据写入到 FileChannel
        fileChannel.write(byteBuffer);

        fileOutputStream.close();
    }
}
