package uestc.EX1;

public class test_class {
    public static void main(String[] args) {
        Course course1=new Course("math", "123", 20);
        Teacher t1=new Teacher("12345", "jack", "male", 50, "professor");
        Class c1=new Class(course1, t1, "101", "123456");

        System.out.println(c1.getClassId());
        System.out.println(c1.getClassroom());
        System.out.println(c1.getTeacher());
        System.out.println(c1.getCourse());
        c1.display();
    }
}
