import java.nio.IntBuffer;

/**
 * zbj: created on 2021/3/7 21:21.
 */
public class Example01_BasicBuffer {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i * 2);
        }

        intBuffer.flip();

        intBuffer.position(1);
        intBuffer.limit(3);

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }

}
