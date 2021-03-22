import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterUUUU = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2021-03-08 11:37:50", formatter);
        System.out.println(parse);

        LocalDateTime now = LocalDateTime.now();
        // BASIC_ISO_DATE yyyyMMdd
        String format = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("BASIC_ISO_DATE#" + format);

        // ISO_DATE yyyy-MM-dd
        String format2 = now.format(DateTimeFormatter.ISO_DATE);
        System.out.println("ISO_DATE#" + format2);

        String format3 = now.format(formatter);
        System.out.println("formatter#" + format3);

        String format4 = now.format(formatterUUUU);
        System.out.println("formatterUUUU#" + format4);

    }

}
