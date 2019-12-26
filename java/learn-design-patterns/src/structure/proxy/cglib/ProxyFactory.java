package structure.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib 开始");
        Object invoke = method.invoke(target, args);
        System.out.println("cglib 结束");
        return invoke;
    }

    public Object getInstance() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类对象，即代理对象
        return enhancer.create();
    }
}
