import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ex_lianggang
 * @Date 2020/3/30 13:39
 * @Version 1.0
 */
public class ApacheCollections {

    ///**
    // * 1、除非元素为null，否则向集合添加元素
    // */
    //        CollectionUtils.addIgnoreNull(personList,null);
    //    /**
    //     * 2、将两个已排序的集合a和b合并为一个已排序的列表，以便保留元素的自然顺序
    //     */
//        CollectionUtils.collate(Iterable<? extends O> a, Iterable<? extends O> b)
//            /**
//             * 3、将两个已排序的集合a和b合并到一个已排序的列表中，以便保留根据Comparator c的元素顺序。
//             */
//            CollectionUtils.collate(Iterable<? extends O> a, Iterable<? extends O> b, Comparator<? super O> c)
//            /**
//             * 4、返回该个集合中是否含有至少有一个元素
//             */
//            CollectionUtils.containsAny(Collection<?> coll1, T... coll2)
//            /**
//             * 5、如果参数是null，则返回不可变的空集合，否则返回参数本身。（很实用 ,最终返回List EMPTY_LIST = new EmptyList<>()）
//             */
//            CollectionUtils.emptyIfNull(Collection<T> collection)
//            /**
//             * 6、空安全检查指定的集合是否为空
//             */
//            CollectionUtils.isEmpty(Collection<?> coll)
//            /**
//             * 7、 空安全检查指定的集合是否为空。
//             */
//            CollectionUtils.isNotEmpty(Collection<?> coll)
//            /**
//             * 8、反转给定数组的顺序。
//             */
//            CollectionUtils.reverseArray(Object[] array);
//    /**
//     * 9、差集
//     */
//        CollectionUtils.subtract(Iterable<? extends O> a, Iterable<? extends O> b)
//            /**
//             * 10、并集
//             */
//            CollectionUtils.union(Iterable<? extends O> a, Iterable<? extends O> b)
//            /**
//             * 11、交集
//             */
//            CollectionUtils.intersection(Collection a, Collection b)
//            /**
//             *12、 交集的补集（析取）
//             */
//            CollectionUtils.disjunction(Collection a, Collection b)

    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");
        CollectionUtils.selectRejected(list1, list -> Integer.parseInt(list.toString()) >2000);
//        1、CollectionUtils.union(list1,list2)； ##[1111, 2222, 3333, 4444, 5555]
//        合并两个集合，不去重
//
//        2、CollectionUtils.intersection(list1,list2)； ##[3333]
//        得到两个集合中相同的元素
//
//        3、CollectionUtils.disjunction(list1,list2) ##[1111, 2222, 4444, 5555]
//        取两个集合的补集
//
//        4、CollectionUtils.subtract(list1,list2)	##[1111, 2222]
//        list1 - list2 = 剩余元素组成的集合
//
//        5、CollectionUtils.containsAny(list1,list2) ##true
//        长的集合包含短的集合的任何一个数据true
//
//        6、CollectionUtils.getCardinalityMap(list1) ##{1111=1, 2222=1, 3333=1}
//        统计集合中各元素出现的次数，并Map<Object, Integer>输出
//
//        7、CollectionUtils.isSubCollection(list1,list2)
//        list1是否list2集合子集，list1集合大小<=list2集合大小
//
//        8、CollectionUtils.isProperSubCollection(list1, list2)
//        a是否b集合子集，a集合大小<b集合大小
//
//        9、CollectionUtils.isEqualCollection(list1,list2)
//        两个集合是否相同
//
//        10、CollectionUtils.cardinality("1111",list1)
//        某元素在集合中出现的次数
//
//        11、CollectionUtils.find(list1,list ->Integer.parseInt(list.toString())>2000)	##2222
//        返回集合中满足函数式的唯一元素，只返回最先处理符合条件的唯一元素
//
//        12、CollectionUtils.filter(list1,list -> Integer.parseInt(list.toString()) >2000); ##2222 3333
//        过滤集合中满足函数式的所有元素
//
//        13、CollectionUtils.countMatches(list1,list -> Integer.parseInt(list.toString()) >2000) ##2
//        返回集合中满足函数式的数量
//
//        14、CollectionUtils.select(list1,list -> Integer.parseInt(list.toString()) >2000) ## [2222, 3333]
//        将满足表达式的元素存入新集合中并返回新集合元素对象
//
//        15、CollectionUtils.selectRejected(list1,list -> Integer.parseInt(list.toString()) >2000)	##[1111]
//        将不满足表达式的元素存入新集合中并返回新集合元素对象
//
//        16、CollectionUtils.addIgnoreNull(list1, "4444") ##[1111, 2222, 3333, 4444]
//        除非元素为null，否则向集合添加元素
//
//        17、CollectionUtils.addAll(list1, new String[]{"4444","5555"}) ##[1111, 2222, 3333, 4444, 5555]
//        将一个数组或集合中的元素全部添加到另一个集合中
//
//        18、CollectionUtils.isEmpty(list1)
//        判断集合是否为空
//
//        19、CollectionUtils.isNotEmpty(list1)
//        判断集合不为空    public static void main(String[] args) {
//        String[] arrayA = new String[] { "1", "2", "3", "4"};
//        String[] arrayB = new String[] { "3", "4", "5", "6" };
//        List<String> listA = Arrays.asList(arrayA);
//        List<String> listB = Arrays.asList(arrayB);
//
//        // 交集
//        List<String> intersection = listA.stream().filter(item -> listB.contains(item)).collect(toList());
//        System.out.println(intersection);
//        //输出:[3, 4]
//
//        // 差集 (list1 - list2)
//        List<String> reduceList = listA.stream().filter(item -> !listB.contains(item)).collect(toList());
//        System.out.println(reduceList);
//        //输出:[1, 2]
//
//        // 并集 （新建集合:1、是因为不影响原始集合。2、Arrays.asList不能add和remove操作。
//        List<String> listAll = listA.parallelStream().collect(toList());
//        List<String> listAll2 = listB.parallelStream().collect(toList());
//        listAll.addAll(listAll2);
//        System.out.println(listAll);
//        //输出:[1, 2, 3, 4, 3, 4, 5, 6]
//
//        // 去重并集
//        List<String> list =new ArrayList<>(listA);
//        list.addAll(listB);
//        List<String> listAllDistinct = list.stream().distinct().collect(toList());
//        System.out.println(listAllDistinct);
//        //输出:[1, 2, 3, 4, 5, 6]
//    }

    }
}
