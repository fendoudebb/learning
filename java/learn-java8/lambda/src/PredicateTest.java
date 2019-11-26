
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = string -> string.length() > 5;
        System.out.println(predicate.test("123456"));
    }
}
