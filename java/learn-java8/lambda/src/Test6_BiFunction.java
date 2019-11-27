import java.util.function.BiFunction;
import java.util.function.Function;

public class Test6_BiFunction {

    public static void main(String[] args) {
        Test6_BiFunction biFunctionTest = new Test6_BiFunction();
        System.out.println(biFunctionTest.compute(1, 2, Integer::sum));


        // 先1+2, 再*10
        System.out.println(biFunctionTest.compute2(1, 2, Integer::sum, integer -> integer * 10));
    }

    public int compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute2(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }

}
