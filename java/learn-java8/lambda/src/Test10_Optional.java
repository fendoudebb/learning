import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Test10_Optional {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();

        //与判断null没差别，不推荐用这方法
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        //推荐使用此方法
        optional.ifPresent(s -> System.out.println("hello"));
        System.out.println(optional.orElse("world"));
        System.out.println(optional.orElseGet(() -> "nihao"));


        //返回值推荐使用此方法，为空返回空集合
        Container container = new Container();
        container.list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(Optional.ofNullable(container).map(container1 -> container1.list).orElse(Collections.emptyList()));


    }

    public static class Container {
        List<Integer> list;
    }

}
