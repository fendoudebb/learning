package action.templatemethod;

public class RedBeanSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("加入红豆");
    }
}
