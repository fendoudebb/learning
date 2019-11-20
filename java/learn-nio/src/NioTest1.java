import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

    // Selector Channel Buffer
    public static void main(String[] args) {
        //刚创建时capacity和limit相同，都是指定的allocate(10)
        IntBuffer buffer = IntBuffer.allocate(10);
        System.out.println("capacity: " + buffer.capacity());
        /*for (int i = 0; i < buffer.capacity(); i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }*/
        for (int i = 0; i < 5; i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            System.out.println("for loop position: " + buffer.position() +
                    ", limit: " + buffer.limit() +
                    ", capacity: " + buffer.capacity() +
                    ", value: " + randomNumber);
            buffer.put(randomNumber);
        }
        //未调用flip() limit不会变
        System.out.println("before flip limit: " + buffer.limit());
        //翻转
        buffer.flip();
        //翻转后的limit指向最后一个读写的位置的下一位
        System.out.println("end flip limit: " + buffer.limit());

        while (buffer.hasRemaining()) {
            System.out.println("while loop position: " + buffer.position() +
                    ", limit: " + buffer.limit() +
                    ", capacity: " + buffer.capacity() +
                    ", value: " + buffer.get());
        }
    }

}
