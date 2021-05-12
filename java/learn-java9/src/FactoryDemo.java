import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * zbj: created on 2021/4/6 21:06.
 */
public class FactoryDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list);

        List<Integer> integers = List.of(5, 6, 7, 8);

        Set<Integer> integers1 = Set.of(1, 3, 5, 7);

        Map<String, Integer> map = Map.of("Tom", 18, "Alice", 20);

        Map<String, Integer> map1 = Map.ofEntries(Map.entry("Tracy", 25), Map.entry("Peter", 30));

    }

}
