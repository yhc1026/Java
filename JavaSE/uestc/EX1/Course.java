package uestc.EX1;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseName;
    private String courseID;
    private int courseHour;

    public Course(String courseName, String courseID, int courseHour)
    {
        this.courseHour=courseHour;
        this.courseID=courseID;
        this.courseName=courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(int courseHour) {
        this.courseHour = courseHour;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void display() {
        System.out.println("Course{courseName='" + courseName + "', courseID='" + courseID + "', courseHour=" + courseHour + "}");
    }
}
