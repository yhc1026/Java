package uestc.EX1;

import java.io.Serializable;

public class Class implements Serializable {
    private String classId;
    private Course course;
    private Teacher teacher;
    private String classroom;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Class(Course course, Teacher teacher, String classroom, String classId) {
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.classId = classId;
    }


    public void display() {
        System.out.println("Class{" + "classId='" + classId + '\'' + ", course=" + course.getCourseName() + ", teacher=" + teacher.getName() + ", classroom='" + classroom + '\'' + '}');
    }
}
