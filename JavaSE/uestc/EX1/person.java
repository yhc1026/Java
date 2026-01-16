package uestc.EX1;

import java.io.Serializable;

public class person implements Serializable {
    protected String name;
    protected String gender;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public person(String name, String gender, int age)
    {
        this.name=name;
        this.gender=gender;
        this.age=age;
    }

    public void display() {
        System.out.println("Person{name='" + name + "', gender='" + gender + "', age=" + age + "}");
    }
}
