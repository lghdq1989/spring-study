import java.util.Optional;

/**
 * @Author ex_lianggang
 * @Date 2020/3/31 10:44
 * @Version 1.0
 */
public class OptionalTest {
    public static void main(String[] args) throws Exception {
//        1 不允许包裹为null的对象，否则程序报错。
//        Optional op = Optional.of(null); //此处会报错
//        System.out.println(op);
//        2 允许包裹对象为nul，为null时返回empty Optional
//        Optional op = Optional.ofNullable(1);
//        System.out.println(op);
//        3 如果值存在并且满足断言，则返回满足条件的Optional，否则返回empty。经常用来做过滤。
//        Optional<String> op = Optional.of("jack");
//        Optional res = op.filter((name)-> name.length()>6);
//        System.out.println(res);
//        4.map(Function<? super T,? extends U> mapper) 如果值存在则对其进行mapping函数操作，如果mappping结果不为空则返回Optional，否则返回empty。
//        Optional<String> op = Optional.of("jack");
//        Optional res = op.map((name) -> "hello,"+name);
//        System.out.println(res);
//        5.功能类似map，只不过需要在mapping函数中，自己封装成Optional。
//        Optional<String> op = Optional.of("jack");
//        Optional res = op.flatMap((name) -> Optional.ofNullable("hello,"+name));
//        System.out.println(res);
//        orElse(T other)
//        6.orElse(T other)值存在则返回，否则返回其它值。相当于给默认值。
//          Optional<String> op = Optional.ofNullable("other");
//          System.out.println(op.orElse("other"));
//        7. orElseGet(Supplier<? extends T> other) 功能类似orElse都是返回值，不同在于它能使用lambda表达式更灵活的处理返回默认值
//        Optional<String> op = Optional.ofNullable(null);
//        System.out.println(op.orElseGet(() -> String.valueOf(true)));
//        8. ifPresent(Consumer<? super T> consumer) 如果值存在，则执行lambda表达式，否则不做任何处理。注意它没有返回值。
//        Optional<String> op = Optional.ofNullable("1111");
//        op.ifPresent((v)->{System.out.println(111);});
    }
}
