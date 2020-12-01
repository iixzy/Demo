package main.com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class TestDate {


//    时间原点概念
//    所有的数据类型，无论是整数，布尔，浮点数还是字符串，最后都需要以数字的形式表现出来。
//    日期类型也不例外，换句话说，一个日期，比如2020年10月1日，在计算机里，会用一个数字来代替。
//    那么最特殊的一个数字，就是零. 零这个数字，就代表Java中的时间原点，其对应的日期是1970年1月1日 8点0分0秒 。
//    (为什么是8点，因为中国的太平洋时区是UTC-8，刚好和格林威治时间差8个小时)
//    为什么对应1970年呢？ 因为1969年发布了第一个 UNIX 版本：AT&T，综合考虑，当时就把1970年当做了时间原点。
//    所有的日期，都是以为这个0点为基准，每过一毫秒，就+1。
    public static void main(String[] args) {

//        // 当前时间
//        Date d1 = new Date();
//        System.out.println("当前时间:");
//        System.out.println(d1);
//        System.out.println();
//        // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
//        Date d2 = new Date(5000);
//        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
//        System.out.println(d2);

//        //注意：是java.util.Date;
//        //而非 java.sql.Date，此类是给数据库访问的时候使用的
//        Date now= new Date();
//        //打印当前时间
//        System.out.println("当前时间:"+now.toString());
//        //getTime() 得到一个long型的整数
//        //这个整数代表 1970.1.1 08:00:00:000，每经历一毫秒，增加1
//        System.out.println("当前时间getTime()返回的值是："+now.getTime());
//        Date zero = new Date(0);
//        System.out.println("用0作为构造方法，得到的日期是:"+zero);

//        System.currentTimeMillis()  ---  当前日期的毫秒数
//        new Date().getTime() 和 System.currentTimeMillis() 是一样的
//        不过由于机器性能的原因，可能会相差几十毫秒，毕竟每执行一行代码，都是需要时间的


////        借助随机数，创建一个从1995.1.1 00:00:00 到 1995.12.31 23:59:59 之间的随机日期
//        //一秒是1000毫秒
//        long second = 1000;
//        //一分钟60秒
//        long minute = second * 60;
//        //一小时60分钟
//        long hour = minute * 60;
//        //一天24小时
//        long day = hour * 24;
//        //一年365天
//        long year = day * 365;
//        //1995年是(1995 - 1970) * 每年的毫秒
//        long year1995Start = (1995 - 1970) * year;
//        //每隔4年多一天
//        long leapDay = (1995-1970)/4*day;
//
//        year1995Start+=leapDay;
//        //8个小时的毫秒数，因为从0毫秒对应的是1970.1.1 08:00:00
//        long eightHour = hour*8;
//
//        year1995Start-=eightHour;
//
//        Date dStart = new Date(year1995Start);
//        System.out.println("1995年第一天："+dStart);
//        long year1995End = year1995Start + year - 1;
//        Date dEnd = new Date(year1995End);
//        System.out.println("1995年最后一天："+dEnd);
//
//        long randomTime = (long) (Math.random()*(year-1) + year1995Start);
//        Date dRandom = new Date(randomTime);
//        System.out.println("1995年这一年中的一个随机时间:" + dRandom);



////        方法2
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//
//        String s1="1995.01.01 00:00:00";
//        String s2="1995.12.31 23:59:59";
//
//        try{
//            Date d1=sdf.parse(s1);
//            System.out.println(d1);
//            Date d2=sdf.parse(s2);
//            System.out.println(d2);
//
//            long n1=d1.getTime();
//            long n2=d2.getTime();
//
//            long n=(long)(Math.random()*(n2-n1)+n1);  //随机毫秒数 （n1-n2之间）
//            Date d=new Date(n);
//            System.out.println("产生的随机日期为："+d);
//
//        } catch (ParseException e){
//
//        }



//        SimpleDateFormat 日期格式化类
////        日期转字符串
//
//        //y 代表年
//        //M 代表月
//        //d 代表日
//        //H 代表24进制的小时
//        //h 代表12进制的小时
//        //m 代表分钟
//        //s 代表秒
//        //S 代表毫秒
//        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
//        Date d= new Date();
//        String str = sdf.format(d);
//        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+str);
//
//        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd" );
//        Date d1= new Date();
//        String str1 = sdf1.format(d1);
//        System.out.println("当前时间通过 yyyy-MM-dd 格式化后的输出: "+str1);


////        字符串转日期
//        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
//
//        String str = "2016/1/5 12:12:12";
//
//        try {
//            Date d = sdf.parse(str);
//            System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss %n转换为日期对象: %s",str,d.toString());
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        准备一个长度是9的日期数组
//        使用1970年-2000年之间的随机日期初始化该数组
//        按照这些日期的时间进行升序排序
//        比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大

//        Date[] dates = new Date[9];
//        int n = dates.length;
//        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
//        String start = "1970-01-01 00:00:00";
//        String end = "2000-12-31 23:59:59";
//        try {
//            Date dateStart = sdf.parse(start);
//            Date dateEnd = sdf.parse(end);
//            long startNum = dateStart.getTime();
//            long endNum = dateEnd.getTime();
//
//            for (int i = 0; i < n; i++) {
//                long randomTime=(long)(Math.random() * (endNum - startNum) + startNum);  //随机毫秒数 （n1-n2之间）
//                Date date = new Date(randomTime);
//                dates[i] = date;
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } finally {
//            Arrays.sort(dates,Collections.reverseOrder());
//            for (Date date : dates) {
//                System.out.println(date);
//            }
//        }

//        扩展 !!!
//        java中对数组进行排序
//        使用Array.sort() 这个默认是升序
//        如果想降序怎么办呢？
//        使用：Arrays.sort(scores, Collections.reverseOrder());
//        需要注意的是 不能使用基本类型（int,double, char），如果是int型需要改成Integer，float要改成Float
//        如果得到的是int数组，怎么办，需要先转换一下

    }
}
