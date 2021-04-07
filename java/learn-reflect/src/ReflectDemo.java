

import com.example.entity.Person;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.reflect.*;

public class ReflectDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {

        // 获取 Class 实例 四种方式
        // 方式一
        Class<Person> personClass = Person.class;

        // 方式二
        Person person = new Person();
        Class<? extends Person> personClass2 = person.getClass();
        System.out.println(personClass2);

        // 方式三 用的较多
        Class<?> personClass3 = Class.forName("com.example.entity.Person");
        System.out.println(personClass3);

        // 方式四
        ClassLoader classLoader = Person.class.getClassLoader();
        Class<?> personClass4 = classLoader.loadClass("com.example.entity.Person");

        System.out.println(personClass == personClass2);
        System.out.println(personClass == personClass3);
        System.out.println(personClass == personClass4);

        System.out.println(personClass2 == personClass3);
        System.out.println(personClass2 == personClass4);

        System.out.println(personClass3 == personClass4);

        // 空参的构造
        Person person1 = personClass.newInstance();


        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        //
        Person jack = constructor.newInstance("Jack", 12);
        System.out.println(jack.toString());

        Field age = personClass.getField("age");
        age.set(jack, 10);
        System.out.println(jack.toString());

        Method sayHello = personClass.getMethod("sayHello");
        sayHello.invoke(jack);



        // 暴力反射
        // 调用私有构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);

        Person alice = declaredConstructor.newInstance("Alice");
        System.out.println(alice.toString());

        // 调用私有成员变量
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(alice, "AliceAAA");
        name.set(jack, "JackAAA");
        System.out.println(alice.toString());
        System.out.println(jack.toString());

        // 调用私有方法
        Method say = personClass.getDeclaredMethod("say", String.class);
        say.setAccessible(true);
        say.invoke(alice, "哈哈哈");

        Class<Object> objectClass = Object.class;
        System.out.println("objectClass = " + objectClass);
        Class<Comparable> comparableClass = Comparable.class;
        System.out.println("comparableClass = " + comparableClass);
        Class<String[]> stringArrayClass = String[].class;
        System.out.println("stringArrayClass = " + stringArrayClass);
        Class<int[][]> tdaClass = int[][].class;
        System.out.println("tdaClass = " + tdaClass);
        Class<ElementType> elementTypeClass = ElementType.class;
        System.out.println("elementTypeClass = " + elementTypeClass);
        Class<Override> overrideClass = Override.class;
        System.out.println("overrideClass = " + overrideClass);
        Class<Integer> integerClass = int.class;
        System.out.println("integerClass = " + integerClass);
        Class<Void> voidClass = void.class;
        System.out.println("voidClass = " + voidClass);
        Class<Class> classClass = Class.class;
        System.out.println("classClass = " + classClass);


    }

}
