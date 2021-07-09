/**
 * zbj: created on 2021/6/20 20:21.
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        ClassLoader platformClassLoader = systemClassLoader.getParent();
        System.out.println(platformClassLoader);
        ClassLoader bootstrapClassLoader = platformClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        System.out.println(ClassLoaderDemo.class.getClassLoader());

        System.out.println(String.class.getClassLoader());

        System.out.println("------------------------");

        String bootstrapClassLoaderPath = System.getProperty("sun.boot.class.path");
        System.out.println("bootstrapClassLoaderPath = " + bootstrapClassLoaderPath);

        String extClassLoaderPath = System.getProperty("java.ext.dirs");
        System.out.println("extClassLoaderPath = " + extClassLoaderPath);

        String appClassLoaderPath = System.getProperty("java.class.path");
        System.out.println("appClassLoaderPath = " + appClassLoaderPath);
    }

}
