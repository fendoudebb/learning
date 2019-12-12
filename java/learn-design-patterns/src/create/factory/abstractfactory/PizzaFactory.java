package create.factory.abstractfactory;

public class PizzaFactory {

    public AbstractFactory abstractFactory;

    public void create(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

}
