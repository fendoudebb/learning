package structure.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        /*return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理开始");
                Object invoke = method.invoke(target, args);
                System.out.println("JDK代理结束");
                return invoke;
            }
        });*/
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("JDK代理开始");
            Object invoke = method.invoke(target, args);
            System.out.println("JDK代理结束");
            return invoke;
        });
    }
}
