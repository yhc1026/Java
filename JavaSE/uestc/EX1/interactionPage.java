package uestc.EX1;

import java.util.Scanner;

public class interactionPage {
    public static void main(String[] args) {
        System.out.println("按1进行学生相关操作");
        System.out.println("");
        System.out.println("按2进行教师相关操作");
        System.out.println("");
        System.out.println("按3进行课程相关操作");
        System.out.println("");
        System.out.println("按4进行排课相关操作");
        System.out.println("");
        System.out.println("按5进行选课相关操作");
        System.out.println("");
        System.out.println("按6查询特定学生选课");
        System.out.println("");
        System.out.println("按ENTER结束操作");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();

        if (res.equals("1")) {
            Student[] students=new Student[3];
            StudentDatabase sdb1 = new StudentDatabase(students);
            System.out.println("按1创建学生信息");
            System.out.println("");
            System.out.println("按2查询全部学生");
            System.out.println("");
            System.out.println("按3查询特定学生");
            System.out.println("");
            System.out.println("按ENTER结束操作");
            Scanner stuscanner = new Scanner(System.in);
            String stures = stuscanner.nextLine();
            if (stures.equals("1")) {
                sdb1.createStudent();
            }
            if (stures.equals("2")) {
                sdb1.readStudentData();
            }
            if(stures.equals("3"))
            {
                sdb1.searchStudentData();
            }
        }

        if (res.equals("2")) {
            Teacher[] teachers=new Teacher[2];
            TeacherDatabase tdb1 = new TeacherDatabase(teachers);
            System.out.println("按1创建教师信息");
            System.out.println("");
            System.out.println("按2查询全部教师");
            System.out.println("");
            System.out.println("按3查询特定教师");
            System.out.println("");
            System.out.println("按ENTER结束操作");
            Scanner tscanner = new Scanner(System.in);
            String tres = tscanner.nextLine();
            if (tres.equals("1")) {
                tdb1.createTeacher();
            }
            if (tres.equals("2")) {
                tdb1.readteacherData();
            }
            if(tres.equals("3"))
            {
                tdb1.searchTeacherData();
            }
        }

        if (res.equals("3")) {
            Course[] courses=new Course[2];
            courseDatabase codb1 = new courseDatabase(courses);
            System.out.println("按1创建课程信息");
            System.out.println("");
            System.out.println("按2查询全部课程");
            System.out.println("");
            System.out.println("按3查询特定课程");
            System.out.println("");
            System.out.println("按ENTER结束操作");
            Scanner coscanner = new Scanner(System.in);
            String cores = coscanner.nextLine();
            if (cores.equals("1")) {
                codb1.createCourse();
            }
            if (cores.equals("2")) {
                codb1.readCourseData();
            }
            if(cores.equals("3"))
            {
                codb1.searchCourseData();
            }
        }

        if (res.equals("4")) {
            Class[] classes=new Class[2];
            classDatabase cldb1 = new classDatabase(classes);
            System.out.println("按1创建排课信息");
            System.out.println("");
            System.out.println("按2查询全部排课");
            System.out.println("");
            System.out.println("按3查询特定排课");
            System.out.println("");
            System.out.println("按ENTER结束操作");
            Scanner clscanner = new Scanner(System.in);
            String clres = clscanner.nextLine();
            if (clres.equals("1")) {
                cldb1.createClass();
            }
            if (clres.equals("2")) {
                cldb1.readCLassData(classes);
            }
            if(clres.equals("3"))
            {
                cldb1.searchClassData();
            }
        }

        if (res.equals("5")) {
            CourseSelection[] courseSelections=new CourseSelection[3];
            selectionDatabase sdb1 = new selectionDatabase(courseSelections);
            System.out.println("按1创建选课信息");
            System.out.println("");
            System.out.println("按2查询全部选课");
            System.out.println("");
            System.out.println("按3查询特定选课");
            System.out.println("");
            System.out.println("按ENTER结束操作");
            Scanner sscanner = new Scanner(System.in);
            String sres = sscanner.nextLine();
            if (sres.equals("1")) {
                sdb1.createSelection();
            }
            if (sres.equals("2")) {
                sdb1.readSelectionData();
            }
            if(sres.equals("3"))
            {
                sdb1.searchSelectionData();
            }
        }

        if (res.equals("6")) {
            CourseSelection[] courseSelections=new CourseSelection[5];
            selectionDatabase sdb=new selectionDatabase(courseSelections);
            System.out.println("输入学生学号");
            Scanner scanner6=new Scanner(System.in);
            String ID=scanner6.nextLine();
            sdb.searchSelectedcourse(ID);
        }
    }
}


