import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author ex_lianggang
 * @Date 2020/3/30 11:24
 * @Version 1.0
 */
public class guavas3 {
//   （1）Guava提供了能够推断范型的静态工厂方法
//
//    List<Person> list = Lists.newArrayList();
//    Map<KeyType, Person> map = Maps.newLinkedHashMap();
//   (2)用工厂方法模式，我们可以方便地在初始化时就指定起始元素。
//
//    Set<Type> copySet = Sets.newHashSet(elements);
//    List<String> theseElements = Lists.newArrayList("alpha", "beta", "gamma");
//  (3)通过为工厂方法命名，
//    我们可以提高集合初始化大小的可读性.
//    List<Type> exactly100 = Lists.newArrayListWithCapacity(100);
//    List<Type> approx100 = Lists.newArrayListWithExpectedSize(100);
//    Set<Type> approx100Set = Sets.newHashSetWithExpectedSize(100);
//    public static void main(String args[]){
//
//        List<String> list1 = Lists.newArrayList();
//        for (int i = 0; i < 10; i++) {
//            list1.add(i + "");
//        }
//        System.out.println("list1: " + list1);
//        //输出：list1: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
//
//        //2、传入多参数
//        List<String> list2 = Lists.newArrayList("1", "2", "3");
//        System.out.println("list2: " + list2);
//        //输出：list2: [1, 2, 3]
//
//        //3、传入数组
//        List<String> list3 = Lists.newArrayList(new String[]{"22", "22"});
//        System.out.println("list3: " + list3);
//        //输出：list3: [22, 22]
//
//        //4、传入集合
//        List<String> list4 = Lists.newArrayList(list1);
//        System.out.println("list4: " + list4);
//        //输出：list4: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
//
//        //5、使用条件：你确定你的容器会装多少个，不确定就用一般形式的
//        //说明：这个容器超过10个还是会自动扩容的。不用担心容量不够用。默认是分配一个容量为10的数组，不够将扩容
//        //整个来说的优点有：节约内存，节约时间，节约性能。代码质量提高。
//        List<String> list = Lists.newArrayListWithExpectedSize(10);
//        //这个方法就是直接返回一个10的数组。
//        List<String> list_ = Lists.newArrayListWithCapacity(10);
//    }
//public static void main(String[] args) {
//
//    //1、Maps.newHashMap()获得HashMap();
//    Map<Integer, Integer> map0 = Maps.newHashMap();
//    for (int i = 0; i < 10; i++) {
//        map0.put(i, i);
//    }
//    System.out.println("map0：" + map0);
//    //输出：map0：{0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 6=6, 7=7, 8=8, 9=9}
//
//    //2、传入map0参数构建map
//    Map<Integer, Integer> map1 = Maps.newHashMap(map0);
//    map1.put(10, 10);
//    System.out.println("map1：" + map1);
//    //输出：map1：{0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 6=6, 7=7, 8=8, 9=9, 10=10}
//
//
//    //3、使用条件：你确定你的容器会装多少个，不确定就用一般形式的
//    //说明：这个容器超过3个还是会自动扩容的。不用担心容量不够用。默认是分配一个容量为16的数组，不够将扩容
//    Map<Integer, Integer> map2 = Maps.newHashMapWithExpectedSize(3);
//    map2.put(1, 1);
//    map2.put(2, 2);
//    map2.put(3, 3);
//    System.out.println("map2：" + map2);
//    //输出：map2：{1=1, 2=2, 3=3}
//
//    //4、LinkedHashMap<K, V> 有序map
//    //Map<Integer,Integer> map3 = Maps.newLinkedHashMap();
//    //Map<Integer,Integer> map3 = Maps.newLinkedHashMapWithExpectedSize(11);
//    Map<Integer, Integer> map3 = Maps.newLinkedHashMap(map1);
//    map3.put(11, 11);
//    System.out.println("map3：" + map3);
//    //输出：map3：{0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 6=6, 7=7, 8=8, 9=9, 10=10, 11=11}
//
//    outMapKeyValue(map3);
//
//}
//    /**
//     * 遍历Map的四种方法
//     */
//    private static void outMapKeyValue(Map<Integer, Integer> map3) {
//
//        //1.通过Map.entrySet遍历key和value
//        for (Map.Entry<Integer, Integer> integerEntry : map3.entrySet()) {
//            System.out.println("key：" + integerEntry.getKey() + " value：" + integerEntry.getValue());
//        }
//
//        //2.通过Map.entrySet使用iterator遍历key和value-----不推荐，直接用上面的for each循环代替此方法
//        Iterator<Map.Entry<Integer, Integer>> it = map3.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<Integer, Integer> entry = it.next();
//            System.out.println("key：" + entry.getKey() + " value：" + entry.getValue());
//        }
//
//        //3.通过Map.keySet遍历key；根据key得到value
//        for (Integer integer : map3.keySet()) {
//            System.out.println("key：" + integer + " value：" + map3.get(integer));
//        }
//
//        //4.通过Map.values()遍历所有的value，但不能遍历key
//        for (Integer integer : map3.values()) {
//            System.out.println("value：" + integer);
//        }
//    }

    public Map<String, Object> map1 = Maps.newHashMap();

    public Map<String, AtomicInteger> map2 = Maps.newHashMap();

    public Map<String, List<String>> map3 = Maps.newHashMap();

    List<String> list = Lists.newArrayList("1", "2", "3", "2", "3", "2");

//    /**
//     * 1、业务逻辑：如果key的value值为null，则在map中放入该key和设置相应的value值
//     */
//    @Test
//    public void map1() {
//
//        // java8之前，从map中根据key获取value操作可能会有下面的操作
//        Object key = map1.get("key");
//        if (key == null) {
//            key = new Object();
//            map1.put("key", key);
//        } else {
//            //如果key对应的value值存在，进行相应的操作
//        }
//
//        // java8之后，上面的操作可以简化为一行，若key对应的value为空，会将第二个参数的返回值存入并返回
//        Object key2 = map1.computeIfAbsent("key1", k -> new Object());
//        System.out.println(map1);
//        //输出：{key1=java.lang.Object@708f5957, key=java.lang.Object@68999068}
//    }
//}

    /**
     * 2、统计List出现相同字符串的个数
     */
    @Test
    public void map2() {

        //这里虽然只有一行代码但信息量很大，首先它采用量java的新特性lambda表达式来遍历list集合
        //这里表示如果map中的key对应的value值为null，则该key对应value值为new AtomicInteger()并执行自增加1，如果key已经存在，则直接value值自增1
        list.forEach(str -> map2.computeIfAbsent(str, k -> new AtomicInteger()).incrementAndGet());
        System.out.println(map2);
        //输出：{1=1, 2=3, 3=2}

    }

    /**
     * 3、如果key对应的value不存在，则创建新List并放入数据，存在则往直接往list放入数据
     */
    @Test
    public void map3() {

        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("apple");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("orange");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("pear");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("banana");
        map3.computeIfAbsent("lisi", k -> genValue(k)).add("water");

        System.out.println(map3);
        //输出结果：{lisi=[water], zhangsan=[apple, orange, pear, banana]}

    }

    static List<String> genValue(String str) {
        return new ArrayList<String>();
    }

    public static void main(String[] args) {
         Map<String, String> map6 = Maps.newHashMap();
        map6.computeIfAbsent("1",l->new String("12"));
        map6.computeIfAbsent("2",l->new String("123"));
        map6.computeIfAbsent("2",l->new String("124"));
        System.out.println(map6);


    }
}
