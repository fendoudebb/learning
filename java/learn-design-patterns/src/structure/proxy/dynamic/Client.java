package structure.proxy.dynamic;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new BuyTicket());
        IBuyTicket proxyInstance = (IBuyTicket) factory.getProxyInstance();
        proxyInstance.buy(200);
    }
}
