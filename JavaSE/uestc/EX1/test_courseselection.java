package uestc.EX1;

public class test_courseselection {
    public static void main(String[] args) {
        Student s1=new Student("123456", "jones", "male", 19, "math");
        Teacher t1=new Teacher("123456", "jack", "male", 50, "professor");
        Course course1=new Course("math", "123", 20);
        Class class1=new Class(course1, t1, "101", "100");

        CourseSelection courseselection1=new CourseSelection(class1, "202309", s1);

        courseselection1.display();
    }
}
