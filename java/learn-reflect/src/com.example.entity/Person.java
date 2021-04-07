package com.example.entity;

@MyAnnotation("Hello This is Class")
public class Person extends Creator<Person> implements MyInterface, Comparable<Integer> {

    @MyAnnotation("Hello This is Private Field")
    private String name;

    @MyAnnotation("Hello This is Public Field")
    public int age;

    String nickname;

    static String ID = "0001";
    final String ID2 = "0001";

    @MyAnnotation("Hello This is Non Param Constructor")
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    @MyAnnotation("Hello This is sayHello Method")
    public void sayHello() throws Exception {
        System.out.println("你好");
    }

    private String say(@MyAnnotation("Hello This is Param") String content) {
        System.out.println("要说的内容是#" + content);
        return content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public String saySomething() {
        return "say from person#" + name + ", age#" + age;
    }

    @Override
    public int compareTo(Integer o) {
        return age;
    }
}
