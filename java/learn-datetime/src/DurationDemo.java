import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo {

    public static void main(String[] args) {
        long diffMillis = Duration.between(LocalDateTime.now(), LocalDateTime.of(LocalDate.now(), LocalTime.MAX)).toMillis();
        System.out.println("millis diff by Duration#" + diffMillis);

        long millisDiff = ChronoUnit.MILLIS.between(LocalDateTime.now(), LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
        System.out.println("当前时间到今晚0点的毫秒值  ChronoUnit#" + millisDiff);
    }

}
