import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * zbj: created on 2021/4/5 7:59.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -8483382254070647732L;

    private String name;

    private Integer age;

    private transient String[] hobby;

    private String aaa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        // 调用默认的反序列化函数
        objectInputStream.defaultReadObject();

        // 手工检查反序列化后年龄
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("age 非法: " + age);
        }

    }
}
