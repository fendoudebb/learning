package uml.aggregation;

/**
 * aggregation: 聚合关系
 * 聚合关系是关联关系的特例
 * 整体和部分的关系，整体与部分可以分开
 * set方法设置Mouse、Keyboard
 */
public class Computer {

    private Mouse mouse;
    private Keyboard keyboard;

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
