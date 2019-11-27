import java.util.function.Function;

public class Test4_Function {

    public static void main(String[] args) {
        Test4_Function test = new Test4_Function();

        //Function 传递的不是值，是行为
        System.out.println(test.compute(1, integer -> integer * 2));

        Function<Integer, String> function = integer -> integer + " hello";
        System.out.println(test.convert(2, function));

    }

    public int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

}
