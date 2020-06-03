import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author ex_lianggang
 * @Date 2020/6/1 10:59
 * @Version 1.0
 */
public class zoneTIme {
    static class TimeZones{
        Date Create;

        public Date getCreate() {
            return Create;
        }

        public void setCreate(Date create) {
            Create = create;
        }
    }
    public static Date dateTransformBetweenTimeZone(Date sourceDate, DateFormat formatter,
                                                      TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
        return new Date(targetTime);
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ParseException {
//              Date date =new Date();
//              java.text.SimpleDateFormat f= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//              TimeZone srcTimeZone = TimeZone.getTimeZone("UTC");
              TimeZone destTimeZone = TimeZone.getTimeZone("Asia/Chongqing");
            System.out.println(destTimeZone.getID());
//              date= zoneTIme.dateTransformBetweenTimeZone(date,f,destTimeZone,srcTimeZone);
//
//             System.out.println(date);
//            TimeZone chongqing = TimeZone.getTimeZone("Asia/Chongqing");
//            DateFormat df = DateFormat.getInstance();
//             String[] ids = TimeZone.getAvailableIDs();
//            for (String id:ids)
//                System.out.printf(id+", ");

//            Class<TimeZones> demoClass = TimeZones.class;
//
//            Field[] declaredFields = demoClass.getDeclaredFields();
//            TimeZones instance = demoClass.newInstance();
//
//            for (Field field : declaredFields) {
//                field.setAccessible(true);
//                //排除非String对象
//                if (field.getType() == Date.class) {
//                    Date times = (Date) field.get(instance);
//                    if(times!=null){
//
//                    }
//
//                }
//            }
//        }
    }
}
