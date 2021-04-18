import java.nio.ByteBuffer;

/**
 * zbj: created on 2021/3/9 22:27.
 */
public class Example07_ReadOnlyBuffer {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();
        // 转为只读Buffer
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        // class java.nio.HeapByteBufferR
        System.out.println(readOnlyBuffer.getClass());

        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        // java.nio.ReadOnlyBufferException
        readOnlyBuffer.put((byte) 100);
    }

}
