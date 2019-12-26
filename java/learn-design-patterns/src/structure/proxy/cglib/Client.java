package structure.proxy.cglib;

public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new BuyTicket());
        BuyTicket buyTicket = (BuyTicket) proxyFactory.getInstance();
        buyTicket.buy();
    }

}
