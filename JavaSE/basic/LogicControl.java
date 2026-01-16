package bit_courseJAVA.basic;

import java.util.Random;
import java.util.Scanner;

public class LogicControl {
    public static void mainSCAN(String[] args) {

        Scanner scan = new Scanner(System.in);//输入函数
        String arr1 = scan.nextLine();//nextLine遇到空格不会结束
        System.out.println(arr1);//输出
        int a1 = scan.nextInt();
        System.out.println(a1);

        int a2 = scan.nextInt();
        System.out.println(a2);
        String arr2 = scan.nextLine();//录入了ENTER，解决方法可以是使用scan.next，避免录入ENTER等字符
        System.out.println(arr2);//输出了ENTER

        String arr3 = scan.next();
        System.out.println(arr3);
    }

    public static void mainRANDOM(String[] args) {
        Random random=new Random();//随机数
        int t=random.nextInt(100);//范围是[0,100)
        System.out.println(t);
    }
    }


