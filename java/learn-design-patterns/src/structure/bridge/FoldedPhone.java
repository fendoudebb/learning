package structure.bridge;

public class FoldedPhone extends Phone {

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("翻盖手机-开机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("翻盖手机-关机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("翻盖手机-打电话");
    }
}
