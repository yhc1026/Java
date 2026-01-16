package uestc.EX1;

public class test_teacher {
    public static void main(String[] args) {
        Teacher t1=new Teacher("123456","jack", "male", 50, "professor");
        System.out.println(t1.age);
        System.out.println(t1.gender);
        System.out.println(t1.name);
        System.out.println(t1.getTeacherID());
        System.out.println(t1.getTitle());
        t1.display();
    }
}
