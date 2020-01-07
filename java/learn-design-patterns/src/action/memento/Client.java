package action.memento;

public class Client {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.vit = 100;
        gameRole.def = 100;
        gameRole.display();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());
        gameRole.vit = 30;
        gameRole.def = 30;
        gameRole.display();

        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        gameRole.display();
    }
}
