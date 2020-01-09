package action.state;

public class NoRaffleState implements State {

    @Override
    public void handle(Raffle raffle) {
        if (raffle.count > 0) {
            System.out.println("NoRaffleState-可以抽奖");
            raffle.setState(new CanRaffleState());
        } else {
            System.out.println("NoRaffleState: 奖品已经领完");
        }
    }
}
