import java.io.Serializable;

public class Singleton implements Serializable {

    public static final long serialVersionUID = -1576643344804979563L;

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    public static synchronized Singleton getSingleton() {
        return SingletonHolder.singleton;
    }

    // 解决序列化单例并不是单例问题
    private Object readResolve() {
        return SingletonHolder.singleton;
    }
}