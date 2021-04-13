import java.io.*;

/**
 * zbj: created on 2021/4/5 7:56.
 */
public class SerializableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serialize();
//        deserialize();

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(
                        new FileOutputStream( new File("singleton.txt") )
                );
        // 将单例对象先序列化到文本文件singleton.txt中
        objectOutputStream.writeObject( Singleton.getSingleton() );
        objectOutputStream.close();

        ObjectInputStream objectInputStream =
                new ObjectInputStream(
                        new FileInputStream( new File("singleton.txt") )
                );
        // 将文本文件singleton.txt中的对象反序列化为singleton1
        Singleton singleton1 = (Singleton) objectInputStream.readObject();
        objectInputStream.close();

        Singleton singleton2 = Singleton.getSingleton();

        // 运行结果竟打印 false ！
        System.out.println( singleton1 == singleton2 );
    }

    private static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("person.txt")));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);
    }

    private static void serialize() throws IOException {
        Person person = new Person();
//        person.setName("Alice");
//        person.setAge(180);
        person.setAge(18);
        String[] hobby = {"basketball"};
        person.setHobby(hobby);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("person.txt")));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
        System.out.println("serialize complete!");
    }

}
