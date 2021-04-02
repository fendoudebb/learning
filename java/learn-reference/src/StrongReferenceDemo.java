public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object(); // 这样定义的默认是强引用
        Object obj2 = obj1; // obj2 引用赋值
        obj1 = null; // 置空
        System.gc();
        System.out.println("obj1=" + obj1);
        System.out.println("obj2=" + obj2);
    }
}
