import java.time.LocalDateTime;

/**
 * zbj: created on 2021/4/13 15:21.
 */
public class Parent {

    public static final ParentStaticFiled PARENT_STATIC_FILED = new ParentStaticFiled();

    public ParentMemberFiled parentMemberFiled = new ParentMemberFiled();

    private String parentMemberVar;

    static {
        System.out.println(LocalDateTime.now() + " Parent static block#" + PARENT_STATIC_FILED);
    }

    {
        System.out.println(LocalDateTime.now() + " Parent non static block#" + parentMemberVar);
    }

    public Parent() {
        parentMemberVar = "pmv";
        System.out.println(LocalDateTime.now() + " Parent Constructor#" + parentMemberVar);
    }
}
