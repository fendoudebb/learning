import java.io.InputStreamReader;

/**
 * zbj: created on 2021/4/6 20:56.
 */
public class TryDemo {

    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            // reader 是 final 的，不能更改
//            reader = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
