import java.util.function.Function;

public class Test5_Function {

    public static void main(String[] args) {
        Test5_Function functionTest2 = new Test5_Function();
        System.out.println(functionTest2.compute(2, integer -> integer * 2, integer -> integer * integer));
        System.out.println(functionTest2.compute2(2, integer -> integer * 2, integer -> integer * integer));

        //Bidirectional
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

}
