package create.factory.abstractfactory;

import create.factory.bean.Pizza;

/**
 * 抽象工厂
 *
 * 1. 将简单工厂模式和工厂方法模式进行整合
 * 2. 将工厂抽象成两层，抽象工厂和具体实现的工厂子类
 * 3. 根据创建对象类型使用对应的工厂子类
 * 4. 将单个的简单工厂类变成了工厂簇
 */
public interface AbstractFactory {

    Pizza createPizza();

    static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        pizzaFactory.create(new CheesePizzaFactory());
        Pizza pizza = pizzaFactory.abstractFactory.createPizza();
        System.out.println(pizza.toString());

    }

}
