import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * zbj: created on 2021/3/10 20:31.
 */
public class Example08_MappedByteBuffer {

    // MappedByteBuffer 可以让文件直接在内存（堆外内存）中修改，操作系统不需要拷贝一次
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        // 参数一：FileChannel.MapMode.READ_WRITE 使用读写模式
        // 参数二：0 可以直接修改的起始位置
        // 参数三：5 映射到内存的大小（不是索引位置），即将文件的多少个字节映射到内存，可以修改的范围就是 [0,5)
        // MappedByteBuffer 实际类型是 DirectByteBuffer
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'h');
        mappedByteBuffer.put(3, (byte) 9);
//        mappedByteBuffer.put(5, (byte) 9); IndexOutOfBoundsException
        randomAccessFile.close();
    }

}
