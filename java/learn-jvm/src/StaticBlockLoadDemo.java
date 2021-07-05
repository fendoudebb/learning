public class StaticBlockLoadDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            StaticBlockLoadLock test = new StaticBlockLoadLock();
        }, "AAA");
        Thread thread2 = new Thread(() -> {
            StaticBlockLoadLock test = new StaticBlockLoadLock();
        }, "BBB");

        thread1.start();
        thread2.start();
    }

}
