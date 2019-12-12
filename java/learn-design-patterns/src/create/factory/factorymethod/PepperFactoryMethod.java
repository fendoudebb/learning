package create.factory.factorymethod;

import create.factory.bean.PepperPizza;
import create.factory.bean.Pizza;

public class PepperFactoryMethod extends FactoryMethod {

    @Override
    public Pizza createPizza(String type) {
        return new PepperPizza();
    }
}
