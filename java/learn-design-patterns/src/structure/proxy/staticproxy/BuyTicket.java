package structure.proxy.staticproxy;

public class BuyTicket implements IBuyTicket {

    @Override
    public void buy(int price) {
        System.out.println("真实购票..." + price);
    }
}
