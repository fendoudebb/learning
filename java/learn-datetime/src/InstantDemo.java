import java.time.Instant;
import java.util.Date;

public class InstantDemo {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant);

        Date date = new Date();
        Instant instant2 = date.toInstant();
        Instant instant1 = Instant.ofEpochMilli(date.getTime());
        System.out.println(instant1);
    }

}
