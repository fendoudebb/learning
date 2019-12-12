package create.factory.abstractfactory;

import create.factory.bean.PepperPizza;
import create.factory.bean.Pizza;

public class PepperPizzaFactory implements AbstractFactory {
    @Override
    public Pizza createPizza() {
        return new PepperPizza();
    }
}
