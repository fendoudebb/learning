package action.memento;

public class GameRole {

    public int vit;
    public int def;

    public Memento createMemento() {
        return new Memento(vit, def);
    }

    public void recoverGameRoleFromMemento(Memento memento) {
        this.vit = memento.vit;
        this.def = memento.def;
    }

    public void display() {
        System.out.println("GameRole: " + vit + " --- " + def);
    }

}
