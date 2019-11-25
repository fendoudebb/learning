import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioTest10_FileLock {
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            FileLock lock = channel.lock();
            System.out.println(lock.isValid());
            System.out.println(lock.isShared());
            lock.release();
        }
    }
}
