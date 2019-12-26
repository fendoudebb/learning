package structure.proxy.staticproxy;

public class Client {

    public static void main(String[] args) {
        IBuyTicket iBuyTicket = new BuyTicketProxy(new BuyTicket());
        iBuyTicket.buy(100);
    }

}
