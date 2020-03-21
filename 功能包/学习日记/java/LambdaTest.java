import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ex_lianggang
 * @Date 2020/3/19 20:34
 * @Version 1.0  //代码之美
 */
public class LambdaTest {
    public static void main(String[] args) {
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

        // 1.2使用 lambda 获得Runnable接口对象
        new Thread(() -> System.out.println("Hello world !")).start();

        //=============================================================================

        // 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        // 2.2使用 lambda直接获得接口对象
        Runnable race2 = () -> System.out.println("Hello world !");

        // 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }
    public  void  TestArray(){
        String[] players = {"zhansgan", "lisi", "wangwu", "zhaoliu",  "wangmazi"};

        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        // 1.2 使用 lambda 排序,根据 surname
        Arrays.sort(players, (String s1, String s2) ->  s1.compareTo(s2));

//================================================================================================

        // 2.1 使用匿名内部类根据 name lenght 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });

        // 2.2使用Lambda,根据name length
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

//==================================================================================================

        // 3.1 使用匿名内部类排序 players, 根据最后一个字母
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

        // 3.2 使用Lambda,根据最后一个字母
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));
    }
    public  void  LambdaTest(){


        List<String> list = Arrays.asList("apple1", "apple2", "apple3", "apple4");

        //lambda 表达式形式
        //appleList.sort((Apple a1, Apple a2) -> {
        //    return new Double(a1.getWeight() - a2.getWeight()).intValue();
        //});

        //静态方法引用形式（可以看出引用方法比上面的更加简单
        //list.sort();

        list.forEach(apple -> System.out.println(apple));
    }
}
