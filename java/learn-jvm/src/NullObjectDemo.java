public class NullObjectDemo {

    public static void main(String[] args) {
        Test test = null;
        test.hello();
        System.out.println(test.count);
    }

}

class Test {
    public static int count = 1;
    public static final int number = 2;

    public static void hello() {
        System.out.println("hello world");
    }
}
