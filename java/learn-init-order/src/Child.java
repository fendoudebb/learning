import java.time.LocalDateTime;

/**
 * zbj: created on 2021/4/13 15:25.
 */
public class Child extends Parent {

    public static final ChildStaticFiled CHILD_STATIC_FILED = new ChildStaticFiled();

    public String childMemberVar = "cmv";

    public ChildMemberFiled childMemberFiled = new ChildMemberFiled();

    static {
        System.out.println(LocalDateTime.now() + " Child static block#" + CHILD_STATIC_FILED);
    }

    {
        System.out.println(LocalDateTime.now() + " Child non static block#" + childMemberVar);
    }

    public Child() {
        System.out.println(LocalDateTime.now() + " Child constructor#" + childMemberVar);
    }

    public static void main(String[] args) {
        Child child = new Child();
    }

}
