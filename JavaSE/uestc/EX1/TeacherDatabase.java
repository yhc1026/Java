package uestc.EX1;

import java.io.*;
import java.util.Scanner;

public class TeacherDatabase {
    private static String filepath="D:/codeC/java-int/JDK18/uestc/EX1/teacher.txt";
    private Teacher[] teacher;

    public TeacherDatabase(Teacher[] teacher) {
        this.teacher = teacher;
    }

    public void createTeacher()
    {

        String name;
        String gender;
        String title;
        String ID;
        int age;

        System.out.println("输入教师名称");
        Scanner scanner1=new Scanner(System.in);
        name=scanner1.nextLine();
        System.out.println("输入工号");
        Scanner scanner2=new Scanner(System.in);
        ID=scanner2.nextLine();
        System.out.println("输入性别");
        Scanner scanner3=new Scanner(System.in);
        gender=scanner3.nextLine();
        System.out.println("输入年龄");
        Scanner scanner4=new Scanner(System.in);
        age= Integer.parseInt(scanner4.nextLine());
        System.out.println("输入职称");
        Scanner scanner5=new Scanner(System.in);
        title=scanner5.nextLine();

        Teacher teacher=new Teacher(ID, name, gender, age, title);
        try {
            MyObjectOutputStream5 oos=new MyObjectOutputStream5(new FileOutputStream(filepath, true));
            oos.writeObject(teacher);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("success");
    }

    public void readteacherData()
    {
        try(MyObjectInputStream5 ois=new MyObjectInputStream5(new FileInputStream(filepath))) {
            for(int i=0;i<teacher.length;i++)
            {
                teacher[i]=(Teacher) ois.readObject();
                System.out.println("教师"+(i+1)+"("+teacher[i].getTitle()+")为"+teacher[i].getName()+", 工号为"+teacher[i].getTeacherID());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<teacher.length;i++)
        {
            teacher[i]=null;
        }
    }

    public void searchTeacherData()
    {
        System.out.println("请输入教师编号");
        Scanner scanner=new Scanner(System.in);
        String ID=scanner.nextLine();

        try(MyObjectInputStream1 ois=new MyObjectInputStream1(new FileInputStream(filepath))) {
            for(int i=0;i<teacher.length;i++)
            {
                teacher[i]=(Teacher) ois.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int cnt=0;
        for(;cnt<teacher.length;cnt++)
        {
            if(teacher[cnt].getTeacherID().equals(ID))
            {
                System.out.println("该教师姓名为"+teacher[cnt].getName()+", 性别为"+teacher[cnt].getGender()+", 职称为"+teacher[cnt].getTitle()+"，年龄为"+teacher[cnt].getAge()+"岁");
                break;
            }
        }
        if(cnt==teacher.length)
        {
            System.out.println("找不到该教师");
        }
        for(int i=0;i<teacher.length;i++)
        {
            teacher[i]=null;
        }
        return;
    }

    public void writeteacherData()
    {
        try (MyObjectOutputStream5 oos=new MyObjectOutputStream5(new FileOutputStream(filepath,true))){

            for(int i=0;i<teacher.length&&teacher[i]!=null;i++)
            {
                oos.writeObject(teacher[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<teacher.length;i++)
        {
            teacher[i]=null;
        }
    }
}

class MyObjectOutputStream5 extends ObjectOutputStream {

    public MyObjectOutputStream5(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //重写读取头部信息方法：不写入头部信息
        super.reset();
    }
}

class MyObjectInputStream5 extends ObjectInputStream {
    public MyObjectInputStream5(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        //重写读取头部信息方法：什么也不做
    }
}