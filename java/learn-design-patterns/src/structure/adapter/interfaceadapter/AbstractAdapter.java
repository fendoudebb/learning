package structure.adapter.interfaceadapter;

/**
 * 接口适配器
 * 将Interface1的方法进行默认实现，实现method1、method2、method3
 */
public abstract class AbstractAdapter implements Interface1 {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    public static void main(String[] args) {
        AbstractAdapter abstractAdapter = new AbstractAdapter() {
            //只需要复写想用的方法即可
            @Override
            public void method1() {
                System.out.println("复写后的method1");
            }
        };
        abstractAdapter.method1();

    }

}
