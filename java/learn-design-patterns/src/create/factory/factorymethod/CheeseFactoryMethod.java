package create.factory.factorymethod;

import create.factory.bean.CheesePizza;
import create.factory.bean.Pizza;

public class CheeseFactoryMethod extends FactoryMethod {

    @Override
    public Pizza createPizza(String type) {
        return new CheesePizza();
    }
}
