import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组与分区
 */
public class Test7_GroupingBy_PartitioningBy {

    public static void main(String[] args) {
        Student zs1 = new Student("zs", 100, 20);
        Student ls = new Student("ls", 90, 25);
        Student ww = new Student("ww", 90, 23);
        Student zs2 = new Student("zs", 85, 30);

        List<Student> list = Arrays.asList(zs1, ls, ww, zs2);
        //{ww=[Student{name='ww', score=90, age=23}], ls=[Student{name='ls', score=90, age=25}], zs=[Student{name='zs', score=100, age=20}, Student{name='zs', score=85, age=30}]}
        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);

        //{100=[Student{name='zs', score=100, age=20}], 85=[Student{name='zs', score=85, age=30}], 90=[Student{name='ls', score=90, age=25}, Student{name='ww', score=90, age=23}]}
        Map<Integer, List<Student>> map1 = list.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(map1);

        //{ww=1, ls=1, zs=2}
        Map<String, Long> map2 = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(map2);

        //{ww=90.0, ls=90.0, zs=92.5}
        Map<String, Double> map3 = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(map3);

        //{false=[Student{name='zs', score=85, age=30}], true=[Student{name='zs', score=100, age=20}, Student{name='ls', score=90, age=25}, Student{name='ww', score=90, age=23}]}
        Map<Boolean, List<Student>> map4 = list.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(map4);

        Long collect = list.stream().collect(Collectors.counting());

        //求最小值min， 最大值max
        list.stream().min(Comparator.comparingInt(Student::getScore)).ifPresent(System.out::println);

        Double collect1 = list.stream().collect(Collectors.averagingInt(Student::getScore));


    }

}

class Student {
    private String name;
    private int score;
    private int age;

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }
}
