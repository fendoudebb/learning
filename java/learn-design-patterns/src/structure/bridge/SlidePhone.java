package structure.bridge;

public class SlidePhone extends Phone {
    public SlidePhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("滑盖手机-开机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("滑盖手机-关机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("滑盖手机-打电话");
    }
}
