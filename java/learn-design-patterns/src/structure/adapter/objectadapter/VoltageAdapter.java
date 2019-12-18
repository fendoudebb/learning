package structure.adapter.objectadapter;

/**
 * 对象适配器
 * 对象适配器和类适配器是同一种思想
 * 使用组合关系代替了继承，解决了类适配器必须继承src的局限性，也不再要求dst必须是接口
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int srcV = voltage220V.output220V();
        int dstV = srcV / 44;
        return dstV;
    }
}
