package create.factory.simplefactory;


import create.factory.bean.CheesePizza;
import create.factory.bean.PepperPizza;
import create.factory.bean.Pizza;

/**
 * 简单工厂模式，也叫静态工厂模式
 * @see java.util.Calendar#createCalendar 用到了简单工厂
 */
public class SimpleFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }

}
