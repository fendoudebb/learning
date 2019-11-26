import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1_forEach {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("-------------");

        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("-------------");

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("-------------");

        // lambda expressions 使用lambda表达式创建
        list.forEach(integer -> System.out.println(integer));

        //method reference 使用方法引用创建
        list.forEach(System.out::println);

    }

}
