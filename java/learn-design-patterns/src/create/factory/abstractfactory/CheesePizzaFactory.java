package create.factory.abstractfactory;

import create.factory.bean.CheesePizza;
import create.factory.bean.Pizza;

public class CheesePizzaFactory implements AbstractFactory{

    @Override
    public Pizza createPizza() {
        return new CheesePizza();
    }
}
