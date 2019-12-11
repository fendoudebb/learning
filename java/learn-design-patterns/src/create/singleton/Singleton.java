package create.singleton;

public class Singleton {

    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton5 singleton5 = Singleton5.getInstance();
        Singleton6 singleton6 = Singleton6.getInstance();
        Singleton7 singleton7 = Singleton7.INSTANCE;
    }

}

/**
 * 饿汉式（静态变量）
 * 1. 无多线程问题
 * 2. 未达到懒加载效果，可能造成内存浪费
 * 3. 可以使用
 *
 * @see java.lang.Runtime
 */
class Singleton1 {
    //1. 私有化构造函数，保证外部不能直接new
    private Singleton1() {
    }

    //2. 类内部创建对象实例
    private static final Singleton1 instance = new Singleton1();

    //3. 提供公有静态方法，返回实例对象
    public static Singleton1 getInstance() {
        return instance;
    }
}

/**
 * 饿汉式（静态代码块）
 * 1. 与饿汉式-静态变量效果一样
 */
class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 懒汉式（线程不安全）
 * 1. 起到懒加载效果，但只能在单线程中使用
 * 2. 实际开发不使用
 */
class Singleton3 {

    private Singleton3() {
    }

    private static Singleton3 instance;

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

/**
 * 懒汉式（线程安全，同步方法）
 * 1. 解决线程不安全问题
 * 2. 获取实例时同步，效率降低
 */
class Singleton4 {
    private Singleton4() {
    }

    private static Singleton4 instance;

    //同步代码
    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

/**
 * 双重检查
 * 推荐使用
 *
 * instance = new Singleton();
 * // 可以分解为以下三个步骤
 * 1 memory=allocate();// 分配内存 相当于c的malloc
 * 2 ctorInstanc(memory) //初始化对象
 * 3 s=memory //设置s指向刚分配的地址
 *
 * // 上述三个步骤可能会被重排序为 1-3-2，也就是：
 * 1 memory=allocate();// 分配内存 相当于c的malloc
 * 3 s=memory //设置s指向刚分配的地址
 * 2 ctorInstanc(memory) //初始化对象
 *
 *如果是1-3-2这个顺序执行，若线程A进入同步锁并执行至“3”这一步，而此时线程B在第一次判断instance是否为空时，是不等于空的，会有问题
 * https://juejin.im/post/5c523889e51d45488e03bba7
 */
class Singleton5 {

    //防止在new对象时指令重排序，其实在基于句柄方式访问对象的编译器（如Symantec JIT）会出现指令重排序
    //HotSpot的反编译：new->dup->invokespecial->putstatic->aload_0，先进行实例化，再存入到静态变量instance
    //HotSpot没有发生重排序
    private static volatile Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 * 当Singleton6加载时，其静态内部类是不会被加载的，只有在调用getInstance()时才加载
 * JVM类的装载机制保证线程安全
 * 懒加载、线程安全
 *
 * 推荐使用
 */
class Singleton6 {

    private Singleton6() {
    }

    private static class SingleInstance {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return SingleInstance.INSTANCE;
    }
}

/**
 * 枚举
 *
 * 推荐使用
 */
enum  Singleton7 {
    INSTANCE
}


