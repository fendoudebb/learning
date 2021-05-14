/**
 * zbj: created on 2021/4/6 20:45.
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void abstractMethod() {
        System.out.println("abstract method");
    }

    public static void main(String[] args) {
        MyInterface.staticMethod();

        MyInterface myInterface = new MyInterfaceImpl();
    }
}
