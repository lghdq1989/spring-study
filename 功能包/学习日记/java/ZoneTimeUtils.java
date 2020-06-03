import javax.xml.ws.WebServiceException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author ex_lianggang
 * @Date 2020/6/1 15:18
 * @Version 1.0
 */
public class ZoneTimeUtils {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ParseException {
        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("UTC"));  // 设置东京时区
        String str =tokyoSdf.format(new Date());
        System.out.println("北京时间: "  +"对应的东京时间为:"  + str);
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Chongqing"));
        System.out.println(tokyoSdf.parse(str));
       tokyoSdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(tokyoSdf.parse(str));
        SimpleDateFormat tokyoSdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        System.out.println(tokyoSdf1.parse(str));
    }
    public static Date dateTransformBetweenTimeZone(Date sourceDate, DateFormat formatter,
                                                    TimeZone sourceTimeZone, TimeZone targetTimeZone) {

        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
        return  new Date(targetTime);
    }

    public static void   dateFormatUTC(Object object, String targetTimeZome, Boolean outOrinput ,List<String> strList)  {
        Class demoClass = object.getClass();
        Field[] declaredFields = demoClass.getDeclaredFields();
        TimeZone srcTimeZone = TimeZone.getTimeZone("UTC");
        TimeZone destTimeZone = TimeZone.getTimeZone(targetTimeZome);

        java.text.SimpleDateFormat f= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                //排除非String对象
                if (strList == null) {
                    if (field.getType() == Date.class || field.get(object) != null) {
                        Date times = (Date) field.get(object);
                        if (times != null) {
                            times = ZoneTimeUtils.dateTransformBetweenTimeZone(times, f, destTimeZone, srcTimeZone);
                            field.set(object, times);
                        }
                    }
                } else {
                    for (String name : strList) {
                        if (field.getType() == Date.class && field.get(object) != null && name.equals(field.getName())) {
                            Date times = (Date) field.get(object);
                            times = ZoneTimeUtils.dateTransformBetweenTimeZone(times, f, destTimeZone, srcTimeZone);
                            field.set(object, times);

                        }
                    }

                }
            }
        }catch (Exception e){

        }
    }
}
