import java.time.*;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateTimeDemo {

    public static void main(String[] args) {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime);

        long ts = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(ts);
        System.out.println(date.getTime());

        long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        long second2 = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        System.out.println(second);
        System.out.println(second2);

        long millis = System.currentTimeMillis();
        LocalDateTime ldt = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();


        LocalTime max = LocalTime.MAX;
        System.out.println(max);
        LocalDateTime endToday = LocalDateTime.of(LocalDate.now(), max);
        System.out.println(endToday );

    }

}
