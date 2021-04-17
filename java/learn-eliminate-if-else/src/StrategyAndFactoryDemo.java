import java.util.HashMap;
import java.util.Map;

/**
 * zbj: created on 2021/4/5 21:49.
 */
public class StrategyAndFactoryDemo {

    public static void main(String[] args) {
        String param = "one";
        if ("one".equals(param)) {
            System.out.println("this is one");
        } else if ("two".equals(param)) {
            System.out.println("this is two");
        } else if ("three".equals(param)) {
            System.out.println("this is three");
        }

        IStrategy strategy = StrategyFactory.getStrategy("two");
        strategy.doSomething();
    }

    private static class StrategyFactory {
        private static final Map<String, IStrategy> map = new HashMap<>();
        static {
            map.put("one", new StrategyOne());
            map.put("two", new StrategyTwo());
            map.put("three", new StrategyThree());
        }

        public static IStrategy getStrategy(String index) {
            return map.get(index);
        }
    }

    private interface IStrategy {
        void doSomething();
    }

    private static class StrategyOne implements IStrategy {

        @Override
        public void doSomething() {
            System.out.println("this is strategy one");
        }
    }

    private static class StrategyTwo implements IStrategy {

        @Override
        public void doSomething() {
            System.out.println("this is strategy two");
        }
    }

    private static class StrategyThree implements IStrategy {

        @Override
        public void doSomething() {
            System.out.println("this is strategy three");
        }
    }

}
