package uestc.EX1;

import org.w3c.dom.ls.LSOutput;

public class test_person {
    public static void main(String[] args) {
        person p1=new person("jack", "male", 20);
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.gender);
        p1.display();
    }
}
