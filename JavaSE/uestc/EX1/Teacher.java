package uestc.EX1;

import java.io.Serializable;

public class Teacher extends person implements Serializable {
    private String teacherID;
    private String title;

    public Teacher(String teacherID, String name, String gender, int age, String title)
    {
        super(name, gender, age);
        this.teacherID=teacherID;
        this.title=title;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println("Teacher{name='" + name + "', gender='" + gender + "', age=" + age + ", teacherID='" + teacherID + "', major='" + title + "'}");
    }
}
