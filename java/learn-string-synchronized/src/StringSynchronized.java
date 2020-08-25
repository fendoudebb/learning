import java.time.LocalDateTime;

public class StringSynchronized {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String lock = String.valueOf(i % 2);
            int finalI = i;
            new Thread(() -> {
                synchronized (lock.intern()) {
                    System.out.println(LocalDateTime.now() + ", lock Current value#" + finalI + ", Current lock#" + lock + ", Current Thread#" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(LocalDateTime.now() + ", unlock Current value#" + finalI + ", Current lock#" + lock + ", Current Thread#" + Thread.currentThread().getId());
                }
            }).start();
        }
    }

}
