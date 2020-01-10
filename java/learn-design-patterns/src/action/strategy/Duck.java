package action.strategy;

public class Duck {

    FlyBehavior flyBehavior;
    BarkBehavior barkBehavior;

    public Duck(FlyBehavior flyBehavior, BarkBehavior barkBehavior) {
        this.flyBehavior = flyBehavior;
        this.barkBehavior = barkBehavior;
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void bark() {
        barkBehavior.bark();
    }

}
