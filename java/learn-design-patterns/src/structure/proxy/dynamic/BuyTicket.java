package structure.proxy.dynamic;

public class BuyTicket implements IBuyTicket {
    @Override
    public String buy(int price) {
        return "购买成功：票价100";
    }
}
