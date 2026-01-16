package uestc.EX1;

public class test_SimpleDatabase {
    public static void main(String[] args) {
        Student s1=new Student("1", "jones", "male", 19, "math");
        Teacher t1=new Teacher("11", "jack", "male", 50, "professor");
        Course course1=new Course("math", "123", 20);
        Class class1=new Class(course1, t1, "101", "100");
        CourseSelection courseselection1=new CourseSelection(class1, "202307", s1);

        Student s2=new Student("2", "mike", "male", 19, "math");
        Teacher t2=new Teacher("12", "ab", "male", 50, "professor");
        Course course2=new Course("math", "100", 20);
        Class class2=new Class(course2, t2, "105", "101");
        CourseSelection courseselection2=new CourseSelection(class2, "202308", s2);

        Student s3=new Student("1234", "sl", "male", 19, "math");
        Teacher t3=new Teacher("15", "me", "male", 50, "professor");
        Course course3=new Course("math", "123", 20);
        Class class3=new Class(course3, t3, "101", "100");
        CourseSelection courseselection3=new CourseSelection(class3, "202309", s3);

        Student s4=new Student("124", "sl", "male", 19, "math");
        Teacher t4=new Teacher("502", "mer", "female", 50, "vice professor");
        Course course4=new Course("math", "143", 85);
        Class class4=new Class(course4, t4, "111", "108");
        CourseSelection courseselection4=new CourseSelection(class4, "2023010", s4);

        Student s5=new Student("1534", "sml", "male", 19, "coding");
        Teacher t5=new Teacher("155", "me", "male", 50, "vice professor");
        Course course5=new Course("python", "153", 25);
        Class class5=new Class(course5, t5, "151", "155");
        CourseSelection courseselection5=new CourseSelection(class5, "202509", s5);

        CourseSelection[] cs=new CourseSelection[5];
        cs[0]=courseselection1;
        cs[1]=courseselection2;
        cs[2]=courseselection3;
        cs[3]=courseselection4;
        cs[4]=courseselection5;

        SimpleDatabase db=new SimpleDatabase("D:/Desktop/select.txt", cs);

        db.writeData();
        db.readData();
    }
}
