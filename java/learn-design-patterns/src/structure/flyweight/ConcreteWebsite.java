package structure.flyweight;

public class ConcreteWebsite extends Website {
    private String type;

    public ConcreteWebsite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println(user.getName() + "正在使用" + type + "网站");
    }
}
