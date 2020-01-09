package action.state;

public class DispensePrizeState implements State {

    @Override
    public void handle(Raffle raffle) {
        if (raffle.count > 0) {
            System.out.println("DispensePrizeState-发奖");
            raffle.count--;
        } else {
            System.out.println("DispensePrizeState-奖品已经领完了");
            raffle.setState(new DispenseOverState());
        }
    }
}
