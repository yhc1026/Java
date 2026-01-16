package uestc.EX1;

import java.io.Serializable;

public class Student extends person implements Serializable {
    private String studentID;
    private String major;

    public Student(String studentID, String name, String gender, int age, String major)
    {
        super(name, gender, age);
        this.studentID=studentID;
        this.major=major;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void display() {
        System.out.println("Student{name='" + name + "', gender='" + gender + "', age=" + age + ", studentID='" + studentID + "', major='" + major + "'}");
    }
}
