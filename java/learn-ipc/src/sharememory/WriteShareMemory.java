package sharememory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * zbj: created on 2021/4/12 17:02.
 */
public class WriteShareMemory {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("share.mm", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            FileLock lock = channel.lock();

            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
            for (int i = 0; i < 10; i++) {
                buffer.put(i, (byte) i);
                Thread.sleep(2000);
            }
            lock.release();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("写入完成");
    }

}
