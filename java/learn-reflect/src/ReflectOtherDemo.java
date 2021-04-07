

import com.example.entity.MyAnnotation;
import com.example.entity.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ReflectOtherDemo {

    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        // 获取当前运行时类中 声明为 public的构造方法
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("-------------");

        // 获取当前运行时类中 声明的所有构造方法
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("-------------");

        // 获取父类
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        // 获取带泛型的父类
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取带泛型的父类的泛型
        ParameterizedType pt = (ParameterizedType) genericSuperclass;
        System.out.println(Arrays.toString(pt.getActualTypeArguments()));

        // 获取实现的接口
        Class<?>[] interfaces = personClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        // 获取包名
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);

        // 获取注解
        Annotation[] annotations = personClass.getAnnotations();

        Override annotation1 = personClass.getAnnotation(Override.class);
        System.out.println(annotation1);// null

        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation ma = (MyAnnotation) annotation;
                System.out.println(ma.value());
            }
        }



    }

}
