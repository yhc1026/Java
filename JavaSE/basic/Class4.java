package bit_courseJAVA.basic;

class student
{
    public int age;
    public static int classnum;

    public static void test4()
    {
        System.out.println("已调用");    //static方法
    }

    public void test(int classnum)
    {
        student.classnum=classnum;//这里不能写this.，因为classnum不属于成员变量
    }

    static                         //静态代码块在类加载的时候就会被调用
    {
        classnum=2;
        System.out.println("已调用");
    }

    {
        System.out.println("非静态代码块已调用");  //非静态代码块会在实例化对象后被调用
    }
}

public class Class4 {
    public static void main(String[] args) {
        //student student1=new student();
        System.out.println(student.classnum);
        student.classnum=1;
        System.out.println(student.classnum);//static修饰的变量为定值，所有student都是同一个classnum,也无需实例化即可调用操作
        student student1=new student();
    }
}
