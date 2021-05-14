/**
 * zbj: created on 2021/4/6 20:43.
 */
public interface MyInterface {

    void abstractMethod();

    static void staticMethod() {
        System.out.println("this is static method");
    }

    default void defaultMethod() {
        System.out.println("this is default method");
    }

    // Java9允许私有方法
    private void privateMethod() {
        System.out.println("this is private method");
    }

}
