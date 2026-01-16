package bit_courseJAVA.basic;

class washmachine
{
    //类的字段，属性，成员变量
    public int price;
    public String brand;
    public String type;

    //行为，成员方法
    public void washclothes()
    {
        System.out.println("wash");
    }
    public void settime()
    {
        System.out.println("11:32");
    }
}

class dog
{
    public String name="GZY";
    public String color="black";

    public void bark()
    {
        System.out.println("汪汪汪");
    }
}

public class Class1 {
    public static void main(String[] args) {
        dog Alaska=new dog();   //通过new关键字将对象dog实例化
        System.out.println(Alaska.color);//通过对象的引用访问
        Alaska.bark();
        dog Laborado=new dog();
        Laborado.color="yellow";
        System.out.println(Laborado.color);


    }
}
