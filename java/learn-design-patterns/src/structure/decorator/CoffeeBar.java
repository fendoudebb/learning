package structure.decorator;


import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class CoffeeBar {

    public static void main(String[] args) throws Exception {
        Drink order = new Espresso();
        System.out.println(order.cost());

        Drink order2 = new Milk(new Espresso());
        System.out.println(order2.cost());

        Drink order3 = new Soy(new Milk(new Milk(new Espresso())));
        System.out.println(order3.cost());

        //IO
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("README.md"));
        System.out.println(br.read());
        br.close();
    }

}
