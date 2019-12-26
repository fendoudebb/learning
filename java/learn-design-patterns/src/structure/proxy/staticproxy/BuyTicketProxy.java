package structure.proxy.staticproxy;

public class BuyTicketProxy implements IBuyTicket {

    private IBuyTicket iBuyTicket;

    public BuyTicketProxy(IBuyTicket iBuyTicket) {
        this.iBuyTicket = iBuyTicket;
    }

    @Override
    public void buy(int price) {
        System.out.println("代理购票开始");
        iBuyTicket.buy(price);
        System.out.println("代理购票结束");
    }
}
