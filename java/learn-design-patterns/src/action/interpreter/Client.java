package action.interpreter;

import java.util.HashSet;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("1+3-5");
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(5);
        int run = calculator.run(set);
        System.out.println(run);
    }
}
