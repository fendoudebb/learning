public class LocalVariablesDemo {

    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesDemo localVariablesDemo = new LocalVariablesDemo();
        int num = 10;
        localVariablesDemo.test1();
    }

    public void test1() {
        int a = this.count;
    }

}
