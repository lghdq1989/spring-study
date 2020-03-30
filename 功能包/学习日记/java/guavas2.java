import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ex_lianggang
 * @Date 2020/3/25 16:56
 * @Version 1.0
 */
public class guavas2 {
//    public static void main(String[] args) {
//        //计算个数
//        String str = "张三 李四 李四 王五 王五 王五";
//        String[] strArr = str.split(" ");
//
//        List<String> words = new ArrayList<String>(Arrays.asList(strArr));
//
//        //创建一个HashMultiset集合，并将words集合数据放入
//        Multiset<String> wordMultiset = HashMultiset.create();
//        wordMultiset.addAll(words);
//
//        //将不同的元素放在一个集合set中
//        for (String key : wordMultiset.elementSet()) {
//            //查看指定元素的个数
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//
//        System.out.println("---------向集合中添加元素----------");
//        //向集合中添加元素
//        wordMultiset.add("李四");
//        for (String key : wordMultiset.elementSet()) {
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//
//        System.out.println("-------向集合中添加若干个元素------");
//        //向集合中添加若干个元素
//        wordMultiset.add("赵六", 10);
//        for (String key : wordMultiset.elementSet()) {
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//
//        System.out.println("--------向集合中移出一个元素------");
//        //向集合中移出一个元素
//        wordMultiset.remove("张三");
//        for (String key : wordMultiset.elementSet()) {
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//
//        System.out.println("------向集合中移出若干个元素------");
//        //向集合中移出若干个元素,如果元素的个数小于要移除的个数，则会把该元素移除光
//        wordMultiset.remove("赵六",5);
//        for (String key : wordMultiset.elementSet()) {
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//
//
//        System.out.println("-----设定某一个元素的重复次数-----");
//        //设定某一个元素的重复次数
//        wordMultiset.setCount("张三", 10);
//        for (String key : wordMultiset.elementSet()) {
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//
//        System.out.println("-----设置复合元素的个数设为新的重复次数-----");
//        //设置复合元素的个数设为新的重复次数(条件是第二个参数的数量要是实际数量一致，否则无效)
//        wordMultiset.setCount("and", 1,0);
//        for (String key : wordMultiset.elementSet()) {
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//
//        System.out.println("-------删除给定集合中的元素------");
//        //删除给定集合中的元素
//        wordMultiset.removeAll(words);
//        for (String key : wordMultiset.elementSet()) {
//            System.out.println(key + "-->" + wordMultiset.count(key));
//        }
//    }

//    //双向map  key value唯一集合
//    BiMap<Integer,String> biMap=HashBiMap.create();
//            biMap.put(1,"张三");
//            biMap.put(2,"李四");
//            biMap.put(3,"王五");
//            biMap.put(4,"赵六");
//            biMap.put(5,"李七");
//            biMap.put(4,"小小");
//
//    //通过key值得到value值(注意key里面的类型根据泛行
//    String value= biMap.get(1);
//            System.out.println("id为1的value值 --"+value);
//
//    //通过value值得到key值
//    int key= biMap.inverse().get("张三");
//            System.out.println("张三key值 --"+key);
//
//    //通过key值重复，那么vakue值会被覆盖。
//    String valuename= biMap.get(4);
//            System.out.println("id为4的value值 --"+valuename);
//}

    public static void main(String args[]){

        //1、将list字符串集合，以,形式转为字符串
        List<String> list =new ArrayList<String>();
        list.add("xx");
        list.add("zz");
        list.add("dd");

        //Joiner.on(",")获得Joiner实例对象
        Joiner joiner =  Joiner.on(",");
        //joiner.join(list)传入操作的集合，并转成字符串格式
        System.out.println(joiner.join(list));
        //输出结果：xx,zz,dd

        //2、将Iterator<T>列表，转为字符串
        Iterator<String> it=list.iterator();
        String  str=Joiner.on("|").join(it);
        System.out.println(str);
        //输出结果：xx|zz|dd

        //3、连接多个字符串
        String str1=Joiner.on(",").join("小小","爸爸","妈妈","爷爷","奶奶");
        System.out.println(str1);
        //输出：小小,爸爸,妈妈,爷爷,奶奶

        //4、连接字符串与列表
        StringBuilder builder=new StringBuilder("小小最乖");
        //返回StringBuilder类型
        StringBuilder str2=Joiner.on(",").appendTo(builder,list);
        System.out.println(str2);
        //输出：小小最乖xx,zz,dd

        //5、跳过null值连接
        list.add(null);
        list.add("小小");
        //skipNulls()代表去除null
        String str3=Joiner.on(",").skipNulls().join(list);
        System.out.println(str3);
        //输出：xx,zz,dd,小小

        //6、替换null值进行连接
        String str4=Joiner.on(",").useForNull("空").join(list);
        System.out.println(str4);
        //输出：xx,zz,dd,空,小小


        //7、Map的键值对打印出来
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        Joiner.MapJoiner mapJoiner = Joiner.on(",").withKeyValueSeparator("=");
        System.out.println(mapJoiner.join(map));
        //输出：key1=value1,key2=value2,key3=value3
        //8、一步将字符串转为List<Long>集合（前面先转为list<String>,后面用java8特性将List<String>转为List<Long>)
        List<Long> lists= Splitter.on("#").splitToList("111#222#333").stream().mapToLong(strs->Long.parseLong(strs)).boxed().distinct().collect(Collectors.toList());
        System.out.println(lists);
    }
//     字符串拆分为list
//    public static void main(String args[]){
//
//        //1、拆分字符串为List集合
//        String str="小小,妈妈,爸爸,爷爷,奶奶";
//        Splitter splitter =Splitter.on(",");
//        List<String> list=splitter.splitToList(str);
//        System.out.println(list);
//        //输出：[小小, 妈妈, 爸爸, 爷爷, 奶奶]
//
//        //2、忽略空字符
//        String str1="a,b,c,d,,f,g";
//        //omitEmptyStrings()代表去除空字符串
//        List<String> list1=Splitter.on(",").omitEmptyStrings().splitToList(str1);
//        System.out.println(list1);
//        //输出：[a, b, c, d, f, g]
//
//        //3、忽略空字符且去除字符串前后空格
//        String str2="a,b,c,d,,f,  g  ";
//        List<String> list2=Splitter.on(",").omitEmptyStrings().trimResults().splitToList(str2);
//        System.out.println(list2);
//        //输出：[a, b, c, d, f, g]
//    }
}
