package action.strategy;

public class NoBarkBehavior implements BarkBehavior {
    @Override
    public void bark() {
        System.out.println("不会叫");
    }
}
