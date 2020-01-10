package action.strategy;

public class GaGaBarkBehavior implements BarkBehavior {
    @Override
    public void bark() {
        System.out.println("嘎嘎叫");
    }
}
