package create.prototype;

/**
 * 不实现Cloneable会抛出异常
 *
 * 1. 可clone基础类型与String
 * 2. 不能clone对象
 */
public class Prototype implements Cloneable {

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    //create.prototype.Prototype@4554617c
    //create.prototype.Prototype@74a14482
    //--------------
    //create.prototype.DeepClonePrototype@1540e19d
    //create.prototype.Helper@677327b6
    //create.prototype.DeepClonePrototype@7ef20235
    //create.prototype.Helper@27d6c5e0
    public static void main(String[] args) throws Exception {
        Prototype prototype = new Prototype();
        System.out.println(prototype);
        Prototype clone = prototype.clone();
        System.out.println(clone);

        System.out.println("--------------");

        DeepClonePrototype deepClonePrototype = new DeepClonePrototype();
        Helper helper = new Helper();
        deepClonePrototype.helper = helper;
        System.out.println(deepClonePrototype);
        System.out.println(helper);
        DeepClonePrototype clone2 = deepClonePrototype.deepClone();
        System.out.println(clone2);
        System.out.println(clone2.helper);


    }

}



