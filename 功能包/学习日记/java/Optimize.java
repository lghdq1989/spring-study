/**
 * @Author ex_lianggang
 * @Date 2020/3/30 11:49
 * @Version 1.0
 */
public class Optimize {
    //优化与禁忌
    public static void main(String[] args) {
//        for (int i = 0; i < list.size(); i++)
//        {...}
//        //建议修改成:
//        for (int i = 0, length = list.size(); i < length; i++)
//        {...}
//        Stringbuffer buffer = new Stringbuffer(); // violation
//        buffer.append ("hello");
////更正好：为stringbuffer提供寝大小。一般循环体内使用都可以知道大小
//        Stringbuffer buffer = new Stringbuffer(max);
//        buffer.append ("hello");
        //条件操作符更加的简捷
//        if (isdone) {
//            return 0;
//        } else {
//            return 10;
//        }
////更正
//        return (isdone ? 0 : 10);
    }

}
