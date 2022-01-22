package until;


import com.sun.org.apache.bcel.internal.generic.LoadClass;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author: wgl
 * @Date: 2020/06/02 09:09
 * @Description:
 */
public class DateUtils {
    public static void main(String[] args) {
        /*new DateUtils().getCurrentDate();
        new DateUtils().getDetailDate();
        new DateUtils().handleSpecialDate();
        new DateUtils().getCurrentTime();*/
        //new DateUtils().plusHours(3);
        //new DateUtils().clock();
        //new DateUtils().isBeforeOrAfter();
        //new DateUtils().getZoneTime();
        new DateUtils().calcDateDays();
    }

    public void getCurrentDate(){
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

        Date date = new Date();
        System.out.println(date);
    }

    public void getDetailDate(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getDayOfYear());
        System.out.printf("Yead : %d Month: %d  day: %d t %n" ,year,month,day);
    }
    public void handleSpecialDate(){
        LocalDate localDate = LocalDate.of(2020,05,25);
        System.out.println(localDate);
    }

    public void getCurrentTime(){
        LocalTime time = LocalTime.now();
        System.out.println("local time now: "+time);
    }
    //在现有时间增加小时数
    public void plusHours(Integer hours){
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime newTime = localTime.plusHours(hours);
        System.out.println(newTime);
    }
    //计算一个星期之后的日期
    public void nextWeek(){
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
    }
    public void clock(){
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemUTC().millis());
    }
    //如何判断日期是早于还是晚于另一个日期
    public void isBeforeOrAfter(){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2020,06,03);
        if (tomorrow.isAfter(today)){
            System.out.println("Tomorrow");
        }

        //减去一天
        LocalDate yesterday = today.minus(1,ChronoUnit.DAYS);
        if (yesterday.isBefore(today)){
            System.out.println("yesterday");
        }
    }
    //获取特定时区下的时间
    public void getZoneTime(){
        //设置时区
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间："+localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,america);
        System.out.println("现在的日期和时间在特定的时区 : " + zonedDateTime);
    }
    //计算两个日期间的天数和月数
    public void calcDateDays(){
        LocalDate today = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2020,Month.OCTOBER,10);
        Period between = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : "+between.getMonths());
        System.out.println("Months left between today and Java 8 release : "+between.getDays());
    }
}
