import java.nio.ByteBuffer;

public class NioTest5 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(10);
        buffer.putLong(10000L);
        buffer.putChar('你');
        buffer.putShort((short)2);
        buffer.putDouble(10.10D);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getDouble());
        //Exception in thread "main" java.nio.BufferUnderflowException
        //	at java.nio.Buffer.nextGetIndex(Buffer.java:506)
        //	at java.nio.HeapByteBuffer.getDouble(HeapByteBuffer.java:514)
        //	at NioTest5.main(NioTest5.java:20)
//        System.out.println(buffer.getDouble());
    }

}
