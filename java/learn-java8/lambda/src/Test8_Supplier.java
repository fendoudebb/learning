import java.util.function.Supplier;

public class Test8_Supplier {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());

        Supplier<Student> studentSupplier = Student::new;

        Student student = studentSupplier.get();
        System.out.println(student);
    }

    public static class Student {

        public Student() {
        }
    }

}
