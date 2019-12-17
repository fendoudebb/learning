package uml.composition;

/**
 * composition: 组合关系
 * 整体与部分的关系，但是整体与部分不可以分开
 * 直接new
 */
public class Computer {
    private Mouse mouse = new Mouse();
    private Keyboard keyboard = new Keyboard();
}
