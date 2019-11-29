import java.util.Arrays;
import java.util.List;

public class Test3_MapReduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //reduce是一个终止操作，及早求值
        System.out.println(list.stream().map(integer -> integer * 2).reduce(0, Integer::sum));
    }

}
