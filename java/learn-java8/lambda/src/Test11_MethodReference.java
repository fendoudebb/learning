import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 方法引用共分为3类
 * 1. 类名::静态方法名
 * 2. 引用名(对象名)::实例方法名
 * 3. 类名::实例方法名
 *
 * 构造方法引用
 * 类名::new
 */
public class Test11_MethodReference {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(integer -> System.out.println(integer));

        //方法引用
        list.forEach(System.out::println);

        list.sort(Comparator.reverseOrder());




    }

}
