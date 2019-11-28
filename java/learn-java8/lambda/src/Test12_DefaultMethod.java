public class Test12_DefaultMethod {

    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2();
        myClass2.myMethod();
    }

}

/**
 * 两个 default 方法名一直，必须重写改方法，使用Interface.super.method()选择
 */
class MyClass implements MyInterface1, MyInterface2 {

    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }
}

/**
 * 实现类的方法比接口的方法级别高一些，所以取实现类中的
 */
class MyClass2 extends MyInterface1Impl implements MyInterface2 {

}

class MyInterface1Impl implements MyInterface1 {
    @Override
    public void myMethod() {
        System.out.println("hello impl");
    }
}

interface MyInterface1 {
    default void myMethod() {
        System.out.println("hello method1");
    }
}

interface MyInterface2 {
    default void myMethod() {
        System.out.println("hello method2");
    }
}
