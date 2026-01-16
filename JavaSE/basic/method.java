package bit_courseJAVA.basic;
//public static+返回值+方法名{方法体}
//方法必须定义在类中，且方法不能嵌套定义
//方法名采用小驼峰形式
public class method {
    public static void main(String[] args)
    {
        int year=2004;
        boolean ret=isLeapYear(year);
        System.out.println(ret);

        int a=1, b=2;
        System.out.println(addUp(a, b));

        noneReturn();

        System.out.println(sum1(5));
        System.out.println(sum2(1729));
    }

    //检查闰年的方法structure：
    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0;
    }

    //实现两个整数相加的方法
    public static int addUp(int a, int b)
    {
        return a+b;
    }

    //无返回值方法
    public static void noneReturn()
    {
        System.out.println("方法已被调用。");
    }

    //方法重载：方法名一样，参数不同，返回值不做要求

    //函数的递归：算阶乘
    public static int sum1(int n)
    {
        if(n==1)
        {
            return 1;
        }
        return sum1(n-1)+n;
    }

    //给一个大于零的数，计算所有数位之和
    public static int sum2(int n)
    {
        if(n/10==0)
        {
            return n;
        }
        return n%10+sum2(n/10);
    }
}


