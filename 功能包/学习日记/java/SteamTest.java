import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ex_lianggang
 * @Date 2020/3/21 9:49
 * @Version 1.0
 */
public class SteamTest {
//
    public class TestSort{
    String[] arr1 = {"abc","a","bc","abcd"};

    /**
     * 按照字符长度排序
     */
    @Test
    public void testSorted1_(){
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        //输出：a、bc、abc、abcd
    }

    /**
     * 倒序
     * reversed(),java8泛型推导的问题，所以如果comparing里面是非方法引用的lambda表达式就没办法直接使用reversed()
     * Comparator.reverseOrder():也是用于翻转顺序，用于比较对象（Stream里面的类型必须是可比较的）
     * Comparator. naturalOrder()：返回一个自然排序比较器，用于比较对象（Stream里面的类型必须是可比较的）
     */
    @Test
    public void testSorted2_(){
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        //输出：abcd、abc、bc、a
        Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //输出：bc、abcd、abc、a
        Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //输出：a、abc、abcd、bc
    }

    /**
     * 先按照首字母排序
     * 之后按照String的长度排序
     */
    @Test
    public void testSorted3_(){
        Arrays.stream(arr1).sorted(Comparator.comparing(this::com1).thenComparing(String::length)).forEach(System.out::println);
    }
    //输出：a、abc、abcd、bc
    public char com1(String x){
        return x.charAt(0);
    }


}

//    public static void main(String[] args) {  集合排序
//        List<Person> persionList = new ArrayList<Person>();
//        persionList.add(new Person(1, "张三", "男", 8));
//        persionList.add(new Person(2, "小小", "女", 2));
//        persionList.add(new Person(3, "李四", "男", 25));
//        persionList.add(new Person(4, "王五", "女", 8));
//        persionList.add(new Person(5, "赵六", "女", 25));
//        persionList.add(new Person(6, "大大", "男", 65));
//
//        //1、找到年龄最小的岁数
//        Collections.sort(persionList, (x, y) -> x.getAge().compareTo(y.getAge()));
//        Integer age = persionList.get(0).getAge();
//        System.out.println("年龄最小的有:" + age);
//        //输出：年龄最小的有:2
//
//        //2、找到年龄最小的姓名
//        String name = persionList.stream()
//                .sorted(Comparator.comparingInt(x -> x.getAge()))
//                .findFirst()
//                .get().getName();
//        System.out.println("年龄最小的姓名:" + name);
//        //输出：年龄最小的姓名:小小
//    }


    /*
     *运行结果：
     *  3
     *  2
     */
//    public static void main(String[] args) {
//        List<Person> persionList = new ArrayList<Person>();
//        persionList.add(new Person(1,"张三","男",38));
//        persionList.add(new Person(2,"小小","女",2));
//        persionList.add(new Person(3,"李四","男",65));
//        persionList.add(new Person(4,"王五","女",20));
//        persionList.add(new Person(5,"赵六","男",38));
//        persionList.add(new Person(6,"大大","男",65));
//        //It works perfect !!
////        List<String> strings = Stream.of("how", "to", "do", "in", "java")
////                .collect(Collectors.toList());
//        //Compilation Error !!错误必须 boxed（）
////        IntStream.of(1,2,3,4,5)
////                .collect(Collectors.toList());
//
//        //1、只取出该集合中所有姓名组成一个新集合
//        List<String> nameList=persionList.stream().map(Person::getName).collect(Collectors.toList());
//        System.out.println(nameList.toString());
//
//        //2、只取出该集合中所有id组成一个新集合
//        List<Integer> idList=persionList.stream().mapToInt(Person::getId).boxed().collect(Collectors.toList());
//        System.out.println(idList.toString());
//
//        //3、list转map，key值为id，value为Person对象
//        Map<Integer, Person> personmap = persionList.stream().collect(Collectors.toMap(Person::getId, person -> person));
//        System.out.println(personmap.toString());
//
//        //4、list转map，key值为id，value为name
//        Map<Integer, String> namemap = persionList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
//        System.out.println(namemap.toString());
//
//        //5、进行map集合存放，key为age值 value为Person对象 它会把相同age的对象放到一个集合中
//        Map<Integer, List<Person>> ageMap = persionList.stream().collect(Collectors.groupingBy(Person::getAge));
//        System.out.println(ageMap.toString());
//
//        //6、获取最小年龄
//        Integer ageMin = persionList.stream().mapToInt(Person::getAge).min().getAsInt();
//        System.out.println("最小年龄为: "+ageMin);
//
//        //7、获取最大年龄
//        Integer ageMax = persionList.stream().mapToInt(Person::getAge).max().getAsInt();
//        System.out.println("最大年龄为: "+ageMax);
//
//        //8、集合年龄属性求和
//        Integer ageAmount = persionList.stream().mapToInt(Person::getAge).sum();
//        System.out.println("年龄总和为: "+ageAmount);
//
//    }
}
