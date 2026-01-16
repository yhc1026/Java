package uestc.EX1;

import java.io.*;
import java.util.Scanner;

public class StudentDatabase {
    private static String filepath="D:/codeC/java-int/JDK18/uestc/EX1/student.txt";
    private Student[] student;



    public StudentDatabase(Student[] student) {
        this.student = student;
    }

    public void createStudent()
    {

        String name;
        String gender;
        String major;
        String ID;
        int age;

        System.out.println("输入学生名称");
        Scanner scanner1=new Scanner(System.in);
        name=scanner1.nextLine();
        System.out.println("输入学号");
        Scanner scanner2=new Scanner(System.in);
        ID=scanner2.nextLine();
        System.out.println("输入性别");
        Scanner scanner3=new Scanner(System.in);
        gender=scanner3.nextLine();
        System.out.println("输入年龄");
        Scanner scanner4=new Scanner(System.in);
        age= Integer.parseInt(scanner4.nextLine());
        System.out.println("输入专业");
        Scanner scanner5=new Scanner(System.in);
        major=scanner5.nextLine();

        Student student=new Student(ID, name, gender, age, major);
        try {
            MyObjectOutputStream1 oos=new MyObjectOutputStream1(new FileOutputStream(filepath, true));
            oos.writeObject(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("success");
    }

    public void readStudentData()
    {
        try(MyObjectInputStream1 ois=new MyObjectInputStream1(new FileInputStream(filepath))) {
            for(int i=0;i<student.length;i++)
            {
                student[i]=(Student)ois.readObject();
                System.out.println("学生"+(i+1)+"为"+student[i].getName()+", 学号为"+student[i].getStudentID());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<student.length;i++)
        {
            student[i]=null;
        }
    }

    public void searchStudentData()
    {
        System.out.println("请输入学生编号");
        Scanner scanner=new Scanner(System.in);
        String ID=scanner.nextLine();

        try(MyObjectInputStream1 ois=new MyObjectInputStream1(new FileInputStream(filepath))) {
            for(int i=0;i<student.length;i++)
            {
                student[i]=(Student)ois.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int cnt=0;
        for(;cnt<student.length;cnt++)
        {
            if(student[cnt].getStudentID().equals(ID))
            {
                System.out.println("该学生姓名为"+student[cnt].getName()+", 性别为"+student[cnt].getGender()+", 专业为"+student[cnt].getMajor());
                break;
            }
        }
        if(cnt==student.length)
        {
            System.out.println("找不到该学生");
        }
        for(int i=0;i<student.length;i++)
        {
            student[i]=null;
        }
        return;
    }

    public void writeStudentData()
    {
        try {
            MyObjectOutputStream1 oos=new MyObjectOutputStream1(new FileOutputStream(filepath));
            for(int i=0;i<student.length&&student[i]!=null;i++)
            {
                oos.writeObject(student[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<student.length;i++)
        {
            student[i]=null;
        }
    }
}

class MyObjectOutputStream1 extends ObjectOutputStream {

    public MyObjectOutputStream1(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //重写读取头部信息方法：不写入头部信息
        super.reset();
    }
}

class MyObjectInputStream1 extends ObjectInputStream {
    public MyObjectInputStream1 (InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        //重写读取头部信息方法：什么也不做
    }
}
