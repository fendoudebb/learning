/**
 * zbj: created on 2021/2/27 23:16.
 */
public class GcRootDemo {

    private int[] array = new int[10];

    public static Object o = new Object();

    public static final String S = "abc";

    public void testMethod() {
        GcRootDemo gcRootDemo = new GcRootDemo();
    }

}
