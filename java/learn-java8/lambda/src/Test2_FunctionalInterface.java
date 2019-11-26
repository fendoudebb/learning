@FunctionalInterface
interface MyInterface {
    void test();

    String toString();
}


public class Test2_FunctionalInterface {

    private void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2_FunctionalInterface test2 = new Test2_FunctionalInterface();
        test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("my test");
            }
        });

        //可以把() -> {}看成是new 对象
        MyInterface myInterface = () -> {
            System.out.println("aaaaaaa");
        };
        test2.myTest(myInterface);

        MyInterface myInterface1 = () -> System.out.println("abc");

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces().length);
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }

}
