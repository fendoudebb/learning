package action.mediator;

public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange, this.name);
    }
}
