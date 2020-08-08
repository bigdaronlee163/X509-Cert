package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtil {

    public static   Date  getCurrentTime(){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
////        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss a"); // a为am/pm的标记
//        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss"); // a为am/pm的标记
        Date date = new Date( );

        return  date ;

    }
    public static   Date  getCurrentNextYearTime(){

        Date date = new Date( );  // new Date()为获取当前系统时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR,1);
        //cal.add(Calendar.DATE, n);//增加一天
        //cal.add(Calendar.DATE, -10);//减10天
        //cal.add(Calendar.MONTH, n);//增加一个月
         return   cal.getTime();
    }







}
