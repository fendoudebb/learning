import java.util.Optional;

/**
 * zbj: created on 2021/4/5 21:03.
 */
public class OptionalDemo {

    public static void main(String[] args) {
        String s = "hello world";

        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("str is empty");
        }

        Optional.of(s).ifPresentOrElse(System.out::println, () -> System.out.println("empty str"));
    }

}
