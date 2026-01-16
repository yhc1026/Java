package uestc.EX1;

import java.io.*;
import java.util.Scanner;

public class classDatabase {
    private static String filepath="D:/codeC/java-int/JDK18/uestc/EX1/class.txt";
    private Class[] classes;

    public classDatabase(Class[] classes) {
        this.classes = classes;
    }


    public void createClass()
    {

        String coursename;
        String courseID;
        int hour;
        System.out.println("输入课程名称");
        Scanner scanner1=new Scanner(System.in);
        coursename=scanner1.nextLine();
        System.out.println("输入课程号");
        Scanner scanner2=new Scanner(System.in);
        courseID=scanner2.nextLine();
        System.out.println("输入课时");
        Scanner scanner4=new Scanner(System.in);
        hour= Integer.parseInt(scanner4.nextLine());
        Course course=new Course(coursename, courseID, hour);

        String teachername;
        String gender;
        String title;
        String teacherID;
        int age;
        System.out.println("输入教师名称");
        Scanner scanner5=new Scanner(System.in);
        teachername=scanner5.nextLine();
        System.out.println("输入工号");
        Scanner scanner6=new Scanner(System.in);
        teacherID=scanner6.nextLine();
        System.out.println("输入性别");
        Scanner scanner7=new Scanner(System.in);
        gender=scanner7.nextLine();
        System.out.println("输入年龄");
        Scanner scanner8=new Scanner(System.in);
        age= Integer.parseInt(scanner8.nextLine());
        System.out.println("输入职称");
        Scanner scanner9=new Scanner(System.in);
        title=scanner9.nextLine();
        Teacher teacher=new Teacher(teacherID, teachername, gender, age, title);

        String classroom;
        System.out.println("输入上课地点");
        Scanner scanner10=new Scanner(System.in);
        classroom=scanner10.nextLine();

        String classID;
        System.out.println("输入排课号");
        Scanner scanner11=new Scanner(System.in);
        classID=scanner11.nextLine();
        Class class1=new Class(course, teacher, classroom, classID);

        try {
            MyObjectOutputStream2 oos=new MyObjectOutputStream2(new FileOutputStream(filepath, true));
            oos.writeObject(class1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("success");
    }

    public void readCLassData(Class[] classes)
    {
        try(MyObjectInputStream2 ois=new MyObjectInputStream2(new FileInputStream(filepath))) {
            for(int i = 0; i< this.classes.length; i++)
            {
                this.classes[i]=(Class) ois.readObject();
                System.out.println("排课"+(i+1)+"为"+ this.classes[i].getCourse().getCourseName()+", 编号为"+ this.classes[i].getClassId()+"，老师为"+ this.classes[i].getTeacher().getName()+", 上课地点为"+ this.classes[i].getClassroom());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i< this.classes.length; i++)
        {
            this.classes[i]=null;
        }
    }

    public void searchClassData()
    {
        System.out.println("请输入排课编号");
        Scanner scanner=new Scanner(System.in);
        String ID=scanner.nextLine();

        try(MyObjectInputStream1 ois=new MyObjectInputStream1(new FileInputStream(filepath))) {
            for(int i = 0; i< classes.length; i++)
            {
                classes[i]=(Class) ois.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int cnt=0;
        for(;cnt<classes.length;cnt++)
        {
            if(classes[cnt].getClassId().equals(ID))
            {
                System.out.println("该排课为"+classes[cnt].getCourse().getCourseName()+", 排课号为"+classes[cnt].getClassId()+", 上课地点为"+classes[cnt].getClassroom()+"，课程编号为"+classes[cnt].getCourse().getCourseID()+", 授课教师为"+classes[cnt].getTeacher().getName());
                break;
            }
        }
        if(cnt==classes.length)
        {
            System.out.println("找不到该排课");
        }
        for(int i=0;i<classes.length;i++)
        {
            classes[i]=null;
        }
        return;
    }

    public void writeCourseData()
    {
        try {
            MyObjectOutputStream2 oos=new MyObjectOutputStream2(new FileOutputStream(filepath));
            for(int i=0;i<classes.length&&classes[i]!=null;i++)
            {
                oos.writeObject(classes[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<classes.length;i++)
        {
            classes[i]=null;
        }
    }
}

class MyObjectOutputStream2 extends ObjectOutputStream {

    public MyObjectOutputStream2(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //重写读取头部信息方法：不写入头部信息
        super.reset();
    }
}

class MyObjectInputStream2 extends ObjectInputStream {
    public MyObjectInputStream2(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        //重写读取头部信息方法：什么也不做
    }
}