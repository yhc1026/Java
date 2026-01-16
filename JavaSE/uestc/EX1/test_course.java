package uestc.EX1;

public class test_course {
    public static void main(String[] args) {
        Course c1=new Course("math", "123", 20);
        System.out.println(c1.getCourseID());
        System.out.println(c1.getCourseHour());
        System.out.println(c1.getCourseName());
        c1.display();
    }
}
