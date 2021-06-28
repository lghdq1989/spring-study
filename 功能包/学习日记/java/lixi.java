import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ex_lianggang
 * @Date 2020/3/30 15:34
 * @Version 1.0
 */
public class lixi {
    public AtomicInteger firstJobDone = new AtomicInteger(0);
        public String name;
        public String id;

    static void getId() {
        throw new RuntimeException();

    }

    public static void main(String[] args) throws Exception {
        System.out.println(firstJobDone.get());
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