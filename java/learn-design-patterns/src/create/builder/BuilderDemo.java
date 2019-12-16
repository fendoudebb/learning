package create.builder;

public class BuilderDemo {

    public static void main(String[] args) {
        User user = User.builder().name("张三").age(20).city("SH").build();
        System.out.println(user.toString());
    }

}

class User {

    private String name;
    private int age;
    private String city;

    public User(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public static User.Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    static class Builder {

        private String name;
        private int age;
        private String city;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            return new User(this.name, this.age, this.city);
        }

    }

}

