package structure.bridge;

public abstract class Phone {

    private Brand brand;//聚合品牌

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.close();
    }

}
