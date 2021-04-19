import java.time.LocalDateTime;

/**
 * zbj: created on 2021/4/13 15:25.
 */
public class Child extends Parent {

    public static String CHILD_STATIC_VAR = "csv";
    public String childLocalVar = "clv";

    public ChildMemberFiled childMemberFiled = new ChildMemberFiled();

    static {
        System.out.println(LocalDateTime.now() + " Child static block#" + CHILD_STATIC_VAR);
    }

    {
        System.out.println(LocalDateTime.now() + " Child non static block#" + childLocalVar);
    }

    public Child() {
        System.out.println(LocalDateTime.now() + " Child constructor#" + childLocalVar);
    }

    public static void main(String[] args) {
        Child child = new Child();
    }

}
