import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ex_lianggang
 * @Date 2020/3/30 15:34
 * @Version 1.0
 */
public class lixi {
    public static void main(String[] args) {
        List str1 =new ArrayList<>();
        str1.add(1);
        str1.add(2);
        str1.add(3);
        List str2 =new ArrayList<>();
        str2.add(2);
        str2.add(3);
        str1.removeAll(str2);
        System.out.println(str1);
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