import com.example.entity.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectFieldDemo {

    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        // 获取当前运行时类及其父类中的方法声明为 public的字段
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("----------------------");

        // 获取当前运行时类中声明的所有属性，不包含父类中声明的属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            // 获取权限修饰符，java.lang.reflect.Modifier
            // PUBLIC 1
            // PRIVATE 2
            // PROTECTED 3
            // STATIC 8
            // FINAL 10
            // SYNCHRONIZED 20
            // VOLATILE 40
            // TRANSIENT 80
            int modifiers = declaredField.getModifiers();
//            System.out.println(Modifier.toString(modifiers));

            // 获取数据类型
            Class<?> type = declaredField.getType();
//            System.out.println(type.getName());

            // 获取变量名
            String name = declaredField.getName();
//            System.out.println(name);

            // 获取注解
            Annotation[] annotations = declaredField.getAnnotations();

            System.out.println("变量修饰符#" + Modifier.toString(modifiers) + ", 类型#" + type.getName() + ", 变量名#" + name+", 字段注解#" + Arrays.toString(annotations));

        }
    }

}
