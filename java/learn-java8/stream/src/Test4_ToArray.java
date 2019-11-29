import java.util.Arrays;
import java.util.stream.Stream;

public class Test4_ToArray {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");
        String[] array = stream.toArray(value -> new String[value]);
//        String[] array2 = stream.toArray(String[]::new);
        System.out.println(Arrays.asList(array));
    }
}
