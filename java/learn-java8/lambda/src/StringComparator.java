import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringComparator {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");


        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        names.sort((String o1, String o2) -> {
            return o2.compareTo(o1);
        });

        names.sort((o1, o2) -> {
            return o2.compareTo(o1);
        });

        names.sort((o1, o2) -> o2.compareTo(o1));

        names.sort(Comparator.reverseOrder());

        System.out.println(names);
    }

}
