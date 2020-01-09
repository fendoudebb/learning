package action.state;

public class Client {
    public static void main(String[] args) {
        Raffle raffle = new Raffle(new NoRaffleState());
        raffle.next();
    }
}
