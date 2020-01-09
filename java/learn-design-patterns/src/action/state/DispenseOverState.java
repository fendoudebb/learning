package action.state;

public class DispenseOverState implements State {

    @Override
    public void handle(Raffle raffle) {
        System.out.println("DispenseOverState-奖品已经领完了");
        raffle.setState(new NoRaffleState());
    }
}
