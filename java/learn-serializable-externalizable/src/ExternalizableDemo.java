import java.io.*;

/**
 * zbj: created on 2021/4/5 12:06.
 */
public class ExternalizableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialize();
        deserialize();
    }

    private static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("animal.txt")));
        Animal animal = (Animal) objectInputStream.readObject();
        System.out.println(animal);
    }

    private static void serialize() throws IOException {
        Animal animal = new Animal("",1);
        animal.setName("小兔子");
        String[] hobby = {"eat"};
        animal.setHobby(hobby);
        animal.setAge(3);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("animal.txt")));
        objectOutputStream.writeObject(animal);
        objectOutputStream.close();
        System.out.println("serialize complete!");
    }

}
