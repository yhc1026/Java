package uestc.EX1;

import java.io.*;
import java.util.Scanner;

public class selectionDatabase {
    private static String filepath="D:/codeC/java-int/JDK18/uestc/EX1/selection.txt";
    private CourseSelection[] courseSelections;

    public selectionDatabase(CourseSelection[] courseSelections) {
        this.courseSelections = courseSelections;
    }

    public void createSelection()
    {

        System.out.println("输入选课号");
        Scanner scanner1=new Scanner(System.in);
        String selectID=scanner1.nextLine();

        String name;
        String gender;
        String major;
        String ID;
        int age;
        System.out.println("输入学生名称");
        Scanner scanner2=new Scanner(System.in);
        name=scanner2.nextLine();
        System.out.println("输入学号");
        Scanner scanner3=new Scanner(System.in);
        ID=scanner3.nextLine();
        System.out.println("输入性别");
        Scanner scanner4=new Scanner(System.in);
        gender=scanner4.nextLine();
        System.out.println("输入年龄");
        Scanner scanner5=new Scanner(System.in);
        age= Integer.parseInt(scanner5.nextLine());
        System.out.println("输入专业");
        Scanner scanner6=new Scanner(System.in);
        major=scanner6.nextLine();
        Student student=new Student(ID, name, gender, age, major);

        String coursename;
        String courseID;
        int hour;
        System.out.println("输入课程名称");
        Scanner scanner7=new Scanner(System.in);
        coursename=scanner7.nextLine();
        System.out.println("输入课程号");
        Scanner scanner8=new Scanner(System.in);
        courseID=scanner8.nextLine();
        System.out.println("输入课时");
        Scanner scanner9=new Scanner(System.in);
        hour= Integer.parseInt(scanner9.nextLine());
        Course course=new Course(coursename, courseID, hour);

        String teachername;
        String gender1;
        String title;
        String teacherID;
        int age1;
        System.out.println("输入教师名称");
        Scanner scanner10=new Scanner(System.in);
        teachername=scanner10.nextLine();
        System.out.println("输入工号");
        Scanner scanner11=new Scanner(System.in);
        teacherID=scanner11.nextLine();
        System.out.println("输入性别");
        Scanner scanner12=new Scanner(System.in);
        gender1=scanner12.nextLine();
        System.out.println("输入年龄");
        Scanner scanner13=new Scanner(System.in);
        age1= Integer.parseInt(scanner13.nextLine());
        System.out.println("输入职称");
        Scanner scanner14=new Scanner(System.in);
        title=scanner14.nextLine();
        Teacher teacher=new Teacher(teacherID, teachername, gender1, age1, title);

        String classroom;
        System.out.println("输入上课地点");
        Scanner scanner15=new Scanner(System.in);
        classroom=scanner15.nextLine();

        String classID;
        System.out.println("输入排课号");
        Scanner scanner16=new Scanner(System.in);
        classID=scanner16.nextLine();
        Class class1=new Class(course, teacher, classroom, classID);

        CourseSelection courseSelection=new CourseSelection(class1, selectID, student);

        try(MyObjectOutputStream4 oos=new MyObjectOutputStream4(new FileOutputStream(filepath,true))) {
            oos.writeObject(courseSelection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("success");
    }

    public void readSelectionData()
    {
        try(MyObjectInputStream4 ois=new MyObjectInputStream4(new FileInputStream(filepath))) {
            for(int i=0;i<courseSelections.length;i++)
            {
                courseSelections[i]=(CourseSelection) ois.readObject();
                System.out.println("选课"+(i+1)+"科目为"+
                        courseSelections[i].getClassTaken().getCourse().getCourseName()+
                        ", 选课号为"+courseSelections[i].getSelectID()+
                        "， 教师为"+courseSelections[i].getClassTaken().getTeacher().getName()+
                        ", 选课学生为"+courseSelections[i].getStudent().getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<courseSelections.length;i++)
        {
            courseSelections[i]=null;
        }
    }

    public void searchSelectionData()
    {
        System.out.println("请输入选课编号");
        Scanner scanner=new Scanner(System.in);
        String ID=scanner.nextLine();

        try(MyObjectInputStream1 ois=new MyObjectInputStream1(new FileInputStream(filepath))) {
            for(int i = 0; i< courseSelections.length; i++)
            {
                courseSelections[i]=(CourseSelection) ois.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int cnt=0;
        for(;cnt<courseSelections.length;cnt++)
        {
            if(courseSelections[cnt].getSelectID().equals(ID))
            {
                System.out.println("该选课为"+courseSelections[cnt].getClassTaken().getCourse().getCourseName()+", 选课学生为"+courseSelections[cnt].getStudent()+", 授课教师为"+courseSelections[cnt].getClassTaken().getTeacher().getName()+"上课地点为"+courseSelections[cnt].getClassTaken().getClassroom());
                break;
            }
        }
        if(cnt==courseSelections.length)
        {
            System.out.println("找不到该选课");
        }
        for(int i=0;i<courseSelections.length;i++)
        {
            courseSelections[i]=null;
        }
        return;
    }

    public void searchSelectedcourse(String ID)
    {
        int t=1;
        boolean flag=false;
        try(MyObjectInputStream1 ois=new MyObjectInputStream1(new FileInputStream(filepath))) {
            for(int i = 0; i< courseSelections.length; i++)
            {
                courseSelections[i]=(CourseSelection) ois.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int cnt=0;
        for(;cnt<courseSelections.length;cnt++)
        {
            if(courseSelections[cnt].getStudent().getStudentID().equals(ID))
            {
                flag=true;
                System.out.println("选课"+t+"为"+courseSelections[cnt].getClassTaken().getCourse().getCourseName()+", 选课学生为"+courseSelections[cnt].getStudent().getName()+", 授课教师为"+courseSelections[cnt].getClassTaken().getTeacher().getName()+"，上课地点为"+courseSelections[cnt].getClassTaken().getClassroom());
                t++;
            }
        }

        if(flag==false)
        {
            System.out.println("找不到该学生的选课");
        }

        for(int i=0;i<courseSelections.length;i++)
        {
            courseSelections[i]=null;
        }
        return;
    }

    public void writeCourseSelectionData()
    {
        try {
            MyObjectOutputStream4 oos=new MyObjectOutputStream4(new FileOutputStream(filepath));
            for(int i=0;i<courseSelections.length&&courseSelections[i]!=null;i++)
            {
                oos.writeObject(courseSelections[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<courseSelections.length;i++)
        {
            courseSelections[i]=null;
        }
    }
}

class MyObjectOutputStream4 extends ObjectOutputStream {

    public MyObjectOutputStream4(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        super.reset();
    }
}

class MyObjectInputStream4 extends ObjectInputStream {
    public MyObjectInputStream4(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
    }
}