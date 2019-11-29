import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5_ToCollection {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");
        List<String> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("--------------");

        List<String> list = Stream.of("hello", "world", "hello world").collect(
                () -> new ArrayList<>(),
                //theList是new 的 ArrayList
                //item是Stream中的每个元素
                (theList, item) -> theList.add(item),
                //将第二步得到的List都加到最终的List中
                //最终返回theList1
                (theList1, theList2) -> theList1.addAll(theList2)
        );
        System.out.println(list);
        System.out.println("--------------");

        List<String> list2 = Stream.of("hello", "world", "hello world")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list2);
        System.out.println("--------------");

        List<String> list1 = Stream.of("hello", "world", "hello world").collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list1);
        System.out.println("--------------");

        Set<String> set = Stream.of("hello", "world", "hello world").collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
        System.out.println("--------------");


        String str = Stream.of("hello", "world", "hello world").collect(Collectors.joining());
//        String str = String.join("", "hello", "world", "hello world");
        System.out.println(str);
        System.out.println("--------------");


        String str1 = Stream.of("hello", "world", "hello world")
                .collect(Collectors.joining(",", "prefix", "suffix"));
        System.out.println(str1);
        System.out.println("--------------");

        List<String> list3 = Arrays.asList("hello", "world");
        list3.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);


    }

}
