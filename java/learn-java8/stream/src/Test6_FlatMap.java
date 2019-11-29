import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6_FlatMap {

    public static void main(String[] args) {
        Stream<List<Integer>> stream = Stream.of(Collections.singletonList(1), Arrays.asList( 2, 3), Arrays.asList(4, 5));
        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
//        stream.flatMap(Collection::stream).map(item -> item * item).forEach(System.out::println);

        System.out.println("-----------");


        List<String> list = Arrays.asList("hello world", "world hello", "hello hello world", "world welcome hello");
        List<String> collect = list.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("-----------");

        List<String> list1 = Arrays.asList("Hi", "你好", "Hello");
        List<String> list2 = Arrays.asList("zhangsan", "wangwu", "lisi");

        List<String> collect1 = list1.stream().flatMap(s -> list2.stream().map(s1 -> s + " " + s1)).collect(Collectors.toList());
        System.out.println(collect1);
    }

}
