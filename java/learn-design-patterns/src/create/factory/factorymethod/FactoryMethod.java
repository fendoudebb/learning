package create.factory.factorymethod;

import create.factory.bean.Pizza;

/**
 * 工厂方法模式
 *
 * 定义一个用于创建对象的抽象方法，由子类决定实例化具体的类，将对象的实例化推迟到子类
 */
public abstract class FactoryMethod {

    public abstract Pizza createPizza(String type);

    public static void main(String[] args) {

        String pizzaType = "cheese";

        Pizza pizza = null;
        if (pizzaType.equals("cheese")) {
            pizza = new CheeseFactoryMethod().createPizza(pizzaType);
        } else if (pizzaType.equals("pepper")) {
            pizza = new PepperFactoryMethod().createPizza(pizzaType);
        }
        System.out.println(pizza.toString());

    }

}
