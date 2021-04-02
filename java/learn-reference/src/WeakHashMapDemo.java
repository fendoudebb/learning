import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
//        myHashMap();
//        myWeakHashMap();
        myWeakHashMap2();
    }

    public static void myWeakHashMap() {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
//        String key = "myWeakKey";
        String key = new String("myWeakKey");
        String value = "myWeakValue";
        weakHashMap.put(key, value);
        System.out.println(weakHashMap);

        key = null;
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
    }

    public static void myWeakHashMap2() {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
//        Integer key = 1;
//        Integer key = 128;
        Integer key = new Integer(1);
        String value = "myWeakValue";
        weakHashMap.put(key, value);
        System.out.println(weakHashMap);

        key = null;
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
    }



    public static void myHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        String key = "myKey";
        String value = "myValue";
        hashMap.put(key, value);

        System.out.println(hashMap);

        key = null;
        System.gc();

        System.out.println(hashMap);



    }

}
