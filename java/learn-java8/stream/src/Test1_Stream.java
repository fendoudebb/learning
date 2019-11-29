import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Test1_Stream {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("hello", "world", "hello world");

        String[] arr = new String[]{"hello", "world", "hello world"};

        Stream<String> stream2 = Stream.of(arr);
        //of的实现就是Arrays.stream(values)
        Stream<String> stream3 = Arrays.stream(arr);

        List<String> list = Arrays.asList(arr);
        Stream<String> stream4 = list.stream();

        Stream<String> generateStream = Stream.generate(UUID.randomUUID()::toString);
        generateStream.findFirst().ifPresent(System.out::println);

        Stream.iterate(1, integer -> integer + 2).limit(6).forEach(System.out::println);

        int sum = Stream.iterate(1, item -> item + 2).limit(6)
                .filter(integer -> integer > 2)
                .mapToInt(integer -> integer * 2)
                .skip(2)
                .limit(2)
                .sum();

        System.out.println(sum);

        System.out.println("----------------");


        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, item -> item + 2).limit(6)
                .filter(integer -> integer > 2)
                .mapToInt(integer -> integer * 2)
                .skip(2)
                .limit(2)
                .summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getSum());

    }

}
