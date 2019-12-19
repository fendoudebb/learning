package structure.bridge;

public class UpRightPhone extends Phone {
    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("直板手机-开机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("直板手机-关机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("直板手机-打电话");
    }
}
