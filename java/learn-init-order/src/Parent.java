import java.time.LocalDateTime;

/**
 * zbj: created on 2021/4/13 15:21.
 */
public class Parent {

    public static final String PARENT_STATIC_VAR;

    public ParentMemberFiled parentMemberFiled = new ParentMemberFiled();

    private String localVar;

    static {
        PARENT_STATIC_VAR = "psv";
        System.out.println(LocalDateTime.now() + " Parent static block");
    }

    {
        System.out.println(LocalDateTime.now() + " Parent non static block");
    }

    public Parent() {
        localVar = "lv";
        System.out.println(LocalDateTime.now() + " Parent Constructor");
    }
}
