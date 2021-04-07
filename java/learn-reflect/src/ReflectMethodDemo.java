import com.example.entity.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectMethodDemo {

    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        // 获取当前运行时类及其父类中的方法声明为 public的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("------------------");

        // 获取当前运行时类中声明的所有方法，不包含父类中声明的方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
            // 1. 获取方法的注解
            Annotation[] annotations = declaredMethod.getAnnotations();
            System.out.print(Arrays.toString(annotations) + "\t");

            // 2. 获取权限修饰符
            System.out.print(Modifier.toString(declaredMethod.getModifiers()) + "\t");

            // 3. 获取返回值类型
            System.out.print(declaredMethod.getReturnType().getName() + "\t");

            // 4. 获取方法名
            System.out.print(declaredMethod.getName() + "\t");

            // 5. 获取参数类型
            System.out.print(Arrays.toString(declaredMethod.getParameters()) + "\t");

            // 6. 获取异常类型
            System.out.print(Arrays.toString(declaredMethod.getExceptionTypes())+"\t");

            System.out.println();
        }

    }

}
