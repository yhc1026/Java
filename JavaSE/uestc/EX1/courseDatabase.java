package uestc.EX1;

import java.io.*;
import java.util.Scanner;

public class courseDatabase {
    private static String filepath="D:/codeC/java-int/JDK18/uestc/EX1/course.txt";
    private Course[] course;

    public courseDatabase(Course[] course) {
        this.course = course;
    }

    public void createCourse()
    {
        String name;
        String ID;
        int hour;

        System.out.println("输入课程名称");
        Scanner scanner1=new Scanner(System.in);
        name=scanner1.nextLine();
        System.out.println("输入课程号");
        Scanner scanner2=new Scanner(System.in);
        ID=scanner2.nextLine();
        System.out.println("输入课时");
        Scanner scanner4=new Scanner(System.in);
        hour= Integer.parseInt(scanner4.nextLine());

        Course course=new Course(name, ID, hour);
        try {
            MyObjectOutputStream3 oos=new MyObjectOutputStream3(new FileOutputStream(filepath, true));
            oos.writeObject(course);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("success");
    }

    public void readCourseData()
    {
        try(MyObjectInputStream3 ois=new MyObjectInputStream3(new FileInputStream(filepath))) {
            for(int i=0;i<course.length;i++)
            {
                course[i]=(Course) ois.readObject();
                System.out.println("课程"+(i+1)+"为"+course[i].getCourseName()+", 课程号为"+course[i].getCourseID()+"课时为"+course[i].getCourseHour()+"h");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<course.length;i++)
        {
            course[i]=null;
        }
    }

    public void searchCourseData()
    {
        System.out.println("请输入课程编号");
        Scanner scanner=new Scanner(System.in);
        String ID=scanner.nextLine();

        try(MyObjectInputStream1 ois=new MyObjectInputStream1(new FileInputStream(filepath))) {
            for(int i = 0; i< course.length; i++)
            {
                course[i]=(Course) ois.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int cnt=0;
        for(;cnt<course.length;cnt++)
        {
            if(course[cnt].getCourseID().equals(ID))
            {
                System.out.println("该课程为"+course[cnt].getCourseName()+", 课时为"+course[cnt].getCourseHour()+"h");
                break;
            }
        }
        if(cnt==course.length)
        {
            System.out.println("找不到该课程");
        }
        for(int i=0;i<course.length;i++)
        {
            course[i]=null;
        }
        return;
    }

    public void writeCourseData()
    {
        try {
            MyObjectOutputStream3 oos=new MyObjectOutputStream3(new FileOutputStream(filepath));
            for(int i=0;i<course.length&&course[i]!=null;i++)
            {
                oos.writeObject(course[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<course.length;i++)
        {
            course[i]=null;
        }
    }
}

class MyObjectOutputStream3 extends ObjectOutputStream {

    public MyObjectOutputStream3(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //重写读取头部信息方法：不写入头部信息
        super.reset();
    }
}

class MyObjectInputStream3 extends ObjectInputStream {
    public MyObjectInputStream3(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        //重写读取头部信息方法：什么也不做
    }
}