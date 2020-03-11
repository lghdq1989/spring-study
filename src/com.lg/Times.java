import java.util.Calendar;

public class Times {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int m =calendar.get(Calendar.MONTH);
        if(m+4>11){
            m=m+4-11;
            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.YEAR)+1);
        }

        System.out.println("m:"+m);
        calendar.set(Calendar.MONTH,m+4);
        calendar.set(Calendar.DATE,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,-1);
        System.out.println(calendar.getTime());
    }
}
