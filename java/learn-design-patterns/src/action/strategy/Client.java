package action.strategy;

public class Client {
    public static void main(String[] args) {
        Duck duck1 = new Duck(new GoodFlyBehavior(), new GaGaBarkBehavior());
        duck1.fly();
        duck1.bark();
        System.out.println("-----------------");
        Duck duck2 = new Duck(new BadFlyBehavior(), new NoBarkBehavior());
        duck2.fly();
        duck2.bark();
    }
}
