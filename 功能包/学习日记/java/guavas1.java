/**
 * @Author ex_lianggang
 * @Date 2020/3/25 15:22
 * @Version 1.0
 */
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class guavas1 {
    public static void main(String[] args) {

    }
    @Test
    public void equalTest() {
        //对比方法
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }
    @Test
    public  void MoreObjects() {
        //name不为空
        String  name="张三";
        String nann=  MoreObjects.firstNonNull(name, "哈哈");
        System.out.println(nann);

        //sex为null
        String   sex=null;
        String   sexx=  MoreObjects.firstNonNull(sex, "哈哈");
        System.out.println(sexx);

    }
    @Test
    public void testGuavaImmutable() {
        //不可变对象
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        ImmutableList<String> imlist = ImmutableList.copyOf(list);
        System.out.println("imlist：" + imlist);

        ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
        System.out.println("imOflist：" + imOflist);

        ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println("imSortList：" + imSortList);
    }
    @Test
    public void testCotyOf(){
        ImmutableSet<String> imSet=ImmutableSet.of("peida","jerry","harry","lisa");
        System.out.println("imSet："+imSet);

        //set直接转list
        ImmutableList<String> imlist=ImmutableList.copyOf(imSet);
        System.out.println("imlist："+imlist);

        //list直接转SortedSet
        ImmutableSortedSet<String> imSortSet=ImmutableSortedSet.copyOf(imSet);
        System.out.println("imSortSet："+imSortSet);

        List<String> list=new ArrayList<String>();
        for(int i=0;i<=10;i++){
            list.add(i+"x");
        }
        System.out.println("list："+list);

        //截取集合部分元素
        ImmutableList<String> imInfolist=ImmutableList.copyOf(list.subList(2, 8));
        System.out.println("imInfolist："+imInfolist);
    }
//    Guava集合和不可变对应关系
//    可变集合类型	可变集合源：JDK or Guava?	Guava不可变集合
//    Collection	JDK	ImmutableCollection
//    List	JDK	ImmutableList
//    Set	JDK	ImmutableSet
//    SortedSet/NavigableSet	JDK	ImmutableSortedSet
//    Map	JDK	ImmutableMap
//    SortedMap	JDK	ImmutableSortedMap
//    Multiset	Guava	ImmutableMultiset
//    SortedMultiset	Guava	ImmutableSortedMultiset
//    Multimap	Guava	ImmutableMultimap
//    ListMultimap	Guava	ImmutableListMultimap
//    SetMultimap	Guava	ImmutableSetMultimap
//    BiMap	Guava	ImmutableBiMap
//    ClassToInstanceMap	Guava	ImmutableClassToInstanceMap
//    Table	Guava	ImmutableTable

}
