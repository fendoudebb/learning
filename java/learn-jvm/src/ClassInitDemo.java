/**
 * zbj: created on 2021/6/20 9:13.
 */
public class ClassInitDemo {

    public static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(num);
        // System.out.println(number); // 非法的前向引用 illegal forward reference
    }

    public static int number = 10;

    public ClassInitDemo() {

        num = 30;

    }

    public static void main(String[] args) {
        System.out.println(ClassInitDemo.num);
        System.out.println(ClassInitDemo.number);
    }

}
