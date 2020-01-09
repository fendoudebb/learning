package action.state;

import java.util.Random;

public class CanRaffleState implements State {

    @Override
    public void handle(Raffle raffle) {
        System.out.println("CanRaffleState-正在抽奖，请稍等！");
        Random r = new Random();
        int num = r.nextInt(10);
        if (num == 0) {
            System.out.println("CanRaffleState-中奖了！！！！！！");
            raffle.setState(new DispensePrizeState());
        } else {
            System.out.println("CanRaffleState-很遗憾没有抽中奖品！");
            raffle.setState(new NoRaffleState());
        }
    }
}
