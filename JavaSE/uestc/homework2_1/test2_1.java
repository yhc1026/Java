package uestc.homework2_1;

public class test2_1 {
    public static void main(String[] args) {
        staff stf1=new staff("John", "China", "UESTC", 0);
        Student std1=new Student("Johnson", "China", "SISE", 4, 2000000);
        System.out.println(std1.toString());
        System.out.println(stf1.toString());
    }
}
