package action.templatemethod;

public abstract class SoyaMilk {

    final void make() {
        select();
        if (customerWantCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    void select() {
        System.out.println("选黄豆");
    }

    //添加不同配料
    abstract void addCondiments();

    void soak() {
        System.out.println("开始浸泡");
    }

    void beat() {
        System.out.println("打碎");
    }

    //钩子方法
    boolean customerWantCondiments() {
        return true;
    }

}
