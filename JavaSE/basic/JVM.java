package bit_courseJAVA.basic;

//JVM的划分

//为什么要划分内存：为了更好地划分数据
//划分出了哪些内存：堆，本地方法栈，JVM栈，方法区，程序计数器
//为什么会有两个栈：本地方法栈会执行一些底层由C/C++代码实现的方法；JVM栈是一般意义的栈

import java.util.Arrays;

public class JVM {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

        System.out.println(Arrays.toString(arr));

        int[]ret=double_(arr);

        System.out.println(Arrays.toString(ret));

        my_ToString(arr);
    }

    public static void Jvm(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2={6,7,8,9,10};
        System.out.println(arr1[1]+" and "+arr2[1]);
        arr2=arr1;
        arr2[1]=0;
        System.out.println(arr1[1]+" and "+arr2[1]);  //输出结果为10，因为arr2和arr1指向同一个对象，arr2改变的数值也会作用于arr上。arr2的原始数据被系统自动free。
    }

    public static void null_()
    {
        int[] arr=null;
        System.out.println(arr.length);//报错NullPointerException，表明使用了null去访问内部变量
    }

    //数组与方法结合：把arr1的每个元素扩大二倍
    public static int[] double_(int[] arr)
    {
        int i=0;
        while(i<arr.length)
        {
            arr[i]*=2;
            i++;
        }
        return arr;
    }

    //实现ToString函数
    public static void my_ToString(int[] arr)
    {
        System.out.print("[");
        int i=0;
        while(i<arr.length)
        {
            if(i+1==arr.length)
            {
                System.out.print(arr[i]);
                i++;
            }
            else
            {
                System.out.print(arr[i]+", ");
                i++;
            }

        }
        System.out.print("]");
    }
}

