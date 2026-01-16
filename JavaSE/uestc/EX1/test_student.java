package uestc.EX1;

public class test_student {
    public static void main(String[] args) {
        Student st1=new Student("123456","jack", "male", 19, "math");
        System.out.println(st1.age);
        System.out.println(st1.gender);
        System.out.println(st1.name);
        System.out.println(st1.getStudentID());
        System.out.println(st1.getMajor());
        st1.display();
    }
}
