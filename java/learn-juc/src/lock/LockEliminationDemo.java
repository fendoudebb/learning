package lock;

public class LockEliminationDemo {

    public void append(String str1, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str1).append(str2);
    }

    public static void main(String[] args) {
        LockEliminationDemo lockEliminationDemo = new LockEliminationDemo();

        long startTs = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            lockEliminationDemo.append("a", "b");
        }
        System.out.println(System.currentTimeMillis() - startTs);
    }

}
