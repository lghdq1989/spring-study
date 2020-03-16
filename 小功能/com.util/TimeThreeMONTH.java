import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeThreeMONTH {
    public static void main(String[] args) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month =calendar.get(Calendar.MONTH) +3;
        if(month>8){

        }

        calendar.set(Calendar.DATE, 1);
        // 时
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 分
        calendar.set(Calendar.MINUTE, 0);
        // 秒
        calendar.set(Calendar.SECOND, 0);
        // 毫秒
        calendar.set(Calendar.MILLISECOND, 0);
//        Date emdTime =
//        System.out.println(format.format(calendar.getTime()));
//        System.out.println(month);

    }
}
