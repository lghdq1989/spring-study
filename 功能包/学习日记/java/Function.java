import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @Author ex_lianggang
 * @Date 2020/3/30 17:40
 * @Version 1.0
 */
public class Function {
    //    jdk8之后新增的一个重要的包 : java.util.function
//
//    该包下所有的接口都是函数式接口, 按分类主要分为四大接口类型: Function、Consumer、Predicate、Supplier。有关Predicate这里不再讲解，因为上面有单独写过一篇博客。
//
//
//    延伸如下
//    public static void main(String[] args) {
//        testAndThen();
//    }
//
//    /**
//     * 一个简单的平方计算
//     */
//
//    public static void testConsumer() {
//        //设置好Consumer实现方法
//        Consumer<Integer> square = x -> System.out.println("平方计算 : " + x * x);
//        //传入值
//        square.accept(2);
//    }
//
//    /**
//     * 定义3个Consumer并按顺序进行调用andThen方法
//     */
//
//    public static void testAndThen() {
//        //当前值
//        Consumer<Integer> consumer1 = x -> System.out.println("当前值 : " + x);
//        //相加
//        Consumer<Integer> consumer2 = x -> {
//            System.out.println("相加 : " + (x + x));
//        };
//        //相乘
//        Consumer<Integer> consumer3 = x -> System.out.println("相乘 : " + x * x);
//        //andThen拼接
//        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
//    }
    //三、Supplier

            public static void main(String args[]){

                Function java8Tester = new Function();
                Integer value1 = null;
                Integer value2 = new Integer(10);

                // Optional.ofNullable - 允许传递为 null 参数
                Optional<Integer> a = Optional.ofNullable(value1);

                // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
                Optional<Integer> b = Optional.of(value2);
                System.out.println(java8Tester.sum(a,b));
            }

            public Integer sum(Optional<Integer> a, Optional<Integer> b){

                // Optional.isPresent - 判断值是否存在

                System.out.println("第一个参数值存在: " + a.isPresent());
                System.out.println("第二个参数值存在: " + b.isPresent());

                // Optional.orElse - 如果值存在，返回它，否则返回默认值
                Integer value1 = a.orElse(new Integer(0));

                //Optional.get - 获取值，值需要存在
                Integer value2 = b.get();
                return value1 + value2;
            }




}
