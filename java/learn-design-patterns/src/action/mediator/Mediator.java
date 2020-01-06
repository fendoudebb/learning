package action.mediator;

public interface Mediator {

    void register(String colleagueName, Colleague colleague);

    void getMessage(int stateChange, String colleagueName);

    void sendMessage();

}
