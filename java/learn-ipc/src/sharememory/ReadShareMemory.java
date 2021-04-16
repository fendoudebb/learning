package sharememory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * zbj: created on 2021/4/12 19:56.
 */
public class ReadShareMemory {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("share.mm", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);

            FileLock lock;

            while (true) {
                lock = channel.tryLock();
                if (lock == null) {
                    Thread.sleep(2000);
                    System.out.println("locked");
                } else {
                    break;
                }
            }

            for (int i = 0; i < 10; i++) {
                System.out.println(buffer.get(i));
            }
            lock.release();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("读取完成");
    }

}
