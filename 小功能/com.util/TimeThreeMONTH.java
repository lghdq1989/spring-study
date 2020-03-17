import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 功能三个月之内
 */
public class TimeThreeMONTH {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(TimeThreeMONTH.checkThreeMonth(format.parse("2020-10-01 00:00:00"),format.parse("2020-04-01 00:00:00")));
    }
    public  static boolean checkThreeMonth(Date startTime,Date endTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        int month =calendar.get(Calendar.MONTH);
        calendar.set(Calendar.DATE, 1);
        // 时
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 分
        calendar.set(Calendar.MINUTE, 0);
        // 秒
        calendar.set(Calendar.SECOND, 0);
        // 毫秒
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH,3);//三个月内
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime().compareTo(endTime)==1?true:false;
    }
}
