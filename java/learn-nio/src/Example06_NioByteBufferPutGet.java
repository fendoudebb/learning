import java.nio.ByteBuffer;

/**
 * zbj: created on 2021/3/9 22:22.
 */
public class Example06_NioByteBufferPutGet {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(100);
        byteBuffer.putLong(9L);
        byteBuffer.putChar('我');
        byteBuffer.putShort((short) 4);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getChar()); // System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getShort());
    }

}
