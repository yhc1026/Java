package bit_courseJAVA.basic.Extends;

public class Cat extends Animals{ //extends关键字，可以将其他类中的方法和成员变量导入当前类
    public void mimi()
    {
        System.out.println("mimi");
    }

    public Cat()
    {
        super("cat1");
    }
}
