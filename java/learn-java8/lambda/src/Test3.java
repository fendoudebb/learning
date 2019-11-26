import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "python", "javascript");
//        List<String> collect = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }

}
