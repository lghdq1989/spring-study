import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ex_lianggang
 * @Date 2020/3/30 15:34
 * @Version 1.0
 */
public class lixi {

        public String name;
        public String id;
    public static void main(String[] args) {
        lixi xi =new lixi();
        xi.name="111";
        lixi xi1 =new lixi();
        xi1.name="222";
        List<lixi> list =new ArrayList<>();
        list.add(xi);
        list.add(xi1);
        list.forEach(item ->{
            item.id="11111111111";
        });
        list.forEach(item->{
            System.out.println(item.id);
        });
        //money(10500.0,0.15 ,11.0);
       // money(10000.0, 0.15,7.0 );
//        String key ="11";
//        if(key==key.toString()){
//            System.out.println(1111);
//        }
    }

    @Test
    public static void money(Double d1, Double d2, Double year) {
        Double one_Year = 0.0;
        Double tol_year = 0.0;

        for (Double i = year; i >0.0; i--) {
            if (one_Year == 0.0) {
                if (i == year) {
                    for (double k = 12; k > 0; k--) {
                        one_Year += (d1 *(d2/12.0*k)) + d1;

                    }
                }
                tol_year=one_Year;

            } else {
                System.out.println("lx"+tol_year * d2);
                tol_year += one_Year + tol_year * d2;

            }


        }
        System.out.println(tol_year);


    }
}