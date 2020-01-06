package action.mediator;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Alarm alarm = new Alarm(mediator, "alarm");
        TV tv = new TV(mediator, "tv");
        alarm.sendMessage(0);
        alarm.sendMessage(1);
    }
}
