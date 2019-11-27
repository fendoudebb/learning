import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Test9_BinaryOperator {

    public static void main(String[] args) {
        Test9_BinaryOperator binaryOperatorTest = new Test9_BinaryOperator();
        System.out.println(binaryOperatorTest.getShort("hello world", "haha", (o1, o2) -> o1.length() - o2.length()));
        System.out.println(binaryOperatorTest.getShort("hello world", "haha", Comparator.comparingInt(String::length)));
    }

    public String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }


}
