package container;

import java.time.LocalDateTime;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/4/2 17:19.
 */
public class VectorDemo {

    public static void main(String[] args) throws InterruptedException {
        Vector<String> vector = new Vector<String>(){
            @Override
            public synchronized boolean add(String o) {
                System.out.println(LocalDateTime.now() + " 添加数据开始");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + " 添加数据完成");
                return super.add(o);
            }

            @Override
            public synchronized String get(int index) {
                System.out.println(LocalDateTime.now() + " 获取数据完成");
                return super.get(index);
            }
        };


        new Thread(() -> {
            vector.add("1234");
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " 获取数据开始");
            System.out.println(vector.get(0));
        }).start();

        TimeUnit.SECONDS.sleep(5);

        for (String s : vector) {
            vector.remove("1234");
        }

    }

}
