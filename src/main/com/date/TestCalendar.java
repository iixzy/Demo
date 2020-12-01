package main.com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *日历类
 */
public class TestCalendar {

//    Calendar类即日历类，常用于进行“翻日历”，比如下个月的今天是多久

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

//        //采用单例模式获取日历对象Calendar.getInstance();
//        Calendar c = Calendar.getInstance();
//        //通过日历对象得到日期对象
//        //和 new Date没有区别
//        Date d = c.getTime();
//        Date d2 = new Date(0);
//        c.setTime(d2); //把这个日历，调成日期 : 1970.1.1 08:00:00
//        System.out.println(c);

//        翻日历
//        add方法，在原日期上增加年/月/日
//        set方法，直接设置年/月/日
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        // 当前日期
        System.out.println("当前日期：\t" + format(c.getTime()));

        // 下个月的今天
        c.setTime(now);
        c.add(Calendar.MONTH, 2);
        System.out.println("下两个月的今天:\t" +format(c.getTime()));

        // 去年的今天
        c.setTime(now);
        c.add(Calendar.YEAR, -1);
        System.out.println("去年的今天:\t" +format(c.getTime()));

        // 上个月的第三天
        c.setTime(now);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 3);
        System.out.println("上个月的第三天:\t" +format(c.getTime()));

        //  2000年2月28日
        c.set(Calendar.YEAR, 2000);
        c.set(Calendar.MONTH, 1); //超过正常月份会增加年的时间 --- 0是一月
        c.set(Calendar.DATE, 28);
        System.out.println("我的生日是:\t" + format(c.getTime()));


//        找出下个月的倒数第3天是哪天
        c.setTime(now);
        System.out.println("现在的时间是:\t" + format(c.getTime()));
        c.add(Calendar.MONTH, 2); // 加两个月 然后减三天
        c.set(Calendar.DATE, -3);
        System.out.println("下个月的倒数第3天是:\t" + format(c.getTime()));
    }

    private static String format(Date time) {
        return sdf.format(time);
    }
}
