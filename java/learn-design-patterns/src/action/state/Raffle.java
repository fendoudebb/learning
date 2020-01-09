package action.state;

public class Raffle {

    int count = 10;

    State state;

    public Raffle(State state) {
        this.state = state;
    }

    public void next() {
        state.handle(this);
    }

    public void setState(State state) {
        this.state = state;
        next();
    }
}
