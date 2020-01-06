package action.mediator;

public class TV extends Colleague {

    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange, this.name);
    }

    public void startTV() {
        System.out.println("Start TV!");
    }

    public void stopTV() {
        System.out.println("Stop TV!");
    }

}
