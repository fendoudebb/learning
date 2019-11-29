import java.util.stream.IntStream;

public class Test2_IntStream {

    public static void main(String[] args) {
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        System.out.println("-------------");

        IntStream.range(3,8).forEach(System.out::println);

        System.out.println("-------------");

        IntStream.rangeClosed(3,8).forEach(System.out::println);
    }

}
