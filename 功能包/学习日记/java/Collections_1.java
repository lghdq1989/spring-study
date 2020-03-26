import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ex_lianggang
 * @Date 2020/3/25 15:53
 * @Version 1.0
 */
public class Collections_1 {
    public static void main(String[] args) {
        //得到一个不可变的list
        List<String> list = new ArrayList<String>();
        list.add("数学");
        list.add("语文");
        Collections_1 coll = new Collections_1();
        Collections_1.Student s = coll.new Student("lily", list);
        List<String> anotherList = s.getCourses();
        /**
         * throws java.lang.UnsupportedOperationException should replace with
         * s.addCourse(String course)
         */
        anotherList.add("英语");
        // 不会走到这一步，因为上边抛出了异常
        System.out.println("lily's course.length = " + s.getCourses().size());
    }

    public class Student {
        private String userName;

        private List<String> courses;

        public Student(String userName, List<String> courses) {
            this.userName = userName;
            this.courses = courses;
        }

        public boolean removeCourse(String course) {
            return courses.remove(courses);

        }

        public List<String> getCourses() {
            return Collections.unmodifiableList(courses);
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void addCourse(String course) {
            courses.add(course);
        }
    }
}
