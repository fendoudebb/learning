import java.util.function.Function;

public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();
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
