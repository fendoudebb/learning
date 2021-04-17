import java.util.HashMap;
import java.util.function.Function;

/**
 * zbj: created on 2021/4/5 21:32.
 */
public class MapDemo {

    public static void main(String[] args) {
        String param = "one";
        if ("one".equals(param)) {
            System.out.println(param.toUpperCase());
        } else if ("two".equals(param)) {
            System.out.println(param.toLowerCase());
        } else if ("three".equals(param)) {
            System.out.println(param.trim());
        }

        HashMap<String, Function<String, String>> map = new HashMap<>();

        map.put("one", String::toUpperCase);
        map.put("two", String::toLowerCase);
        map.put("three", String::trim);

        String apply = map.get("three").apply("abc");
        System.out.println(apply);
    }


}
