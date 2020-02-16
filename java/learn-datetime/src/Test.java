import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * zbj: created on 2020/2/16 20:18.
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        LocalDate now = LocalDate.now();

        LocalDateTime endToday = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(endToday.getNano());

        //年，月，日
        Period p = Period.between(now, LocalDate.ofYearDay(2020, 30));

        System.out.printf("目标日期距离今天的时间差：%d 年 %d 个月 %d 天\n", p.getYears(), p.getMonths(), p.getDays());

        //纳秒，微妙，毫秒，秒，分，小时，半天，天，星期，月，年，十年，世纪，千年，纪元，永远
        long millisDiff = ChronoUnit.MILLIS.between(LocalDateTime.now(), endToday);
        System.out.println("millis diff by ChronoUnit#" + millisDiff);

        //毫秒，秒，分钟，小时，
        Calendar endTodayCalendar = Calendar.getInstance();
//        endTodayCalendar.setTimeInMillis(endTodayCalendar.getTimeInMillis() - System.currentTimeMillis());
        endTodayCalendar.set(Calendar.HOUR_OF_DAY, 23);
        endTodayCalendar.set(Calendar.MINUTE, 59);
        endTodayCalendar.set(Calendar.SECOND, 59);
        endTodayCalendar.set(Calendar.MILLISECOND, 999);
        System.out.println(endTodayCalendar.getTime());
        long mi = endTodayCalendar.getTimeInMillis() - System.currentTimeMillis();
        System.out.println("millis diff by Calendar#" + mi);


        long l = Duration.between(LocalDateTime.now(), endToday).toMillis();
        System.out.println("millis diff by Duration#" + l);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59 999");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(simpleDateFormat2.parse(format).getTime() - System.currentTimeMillis());


        long current = System.currentTimeMillis();

        //今天零点零分零秒的毫秒数
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();

        //今天23点59分59秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000 - 1;
        System.out.println("current#" + current);
        System.out.println("zero#" + zero);
        System.out.println("twelve#" + (twelve - current));
    }

}
