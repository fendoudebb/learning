/**
 * 默认设置 大概在20000次左右
 * -Xss256k 执行2600次左右
 */
public class StackOverflowErrorDemo {

    public static int count = 1;

    public static void main(String[] args) {
        try {
            count++;
            main(args);
        } catch (Throwable e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }

}
