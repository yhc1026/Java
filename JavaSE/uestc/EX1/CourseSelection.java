package uestc.EX1;

import java.io.Serializable;

public class CourseSelection implements Serializable {
    private String selectID;
    private Student student;
    private Class classTaken;

    public String getSelectID() {
        return selectID;
    }

    public void setSelectID(String selectID) {
        this.selectID = selectID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getClassTaken() {
        return classTaken;
    }

    public void setClassTaken(Class classTaken) {
        this.classTaken = classTaken;
    }

    public CourseSelection(Class classTaken, String selectID, Student student) {
        this.classTaken = classTaken;
        this.selectID = selectID;
        this.student = student;
    }


    public void display() {
        System.out.println("CourseSelection{" +
                "selectID='" + selectID + '\'' +
                ", student=" + student.getName() +
                ", classTaken=" + classTaken.getClassroom() +
                '}');
    }
}
