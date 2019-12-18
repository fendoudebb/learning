package structure.adapter.classadapter;

/**
 * 类适配器
 * VoltageAdapter是适配器类
 * 通过继承src类，实现dst接口，完成src->dst的适配
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    @Override
    public int output5V() {
        int srcV = output220V();
        int dstV = srcV / 44;
        return dstV;
    }
}
