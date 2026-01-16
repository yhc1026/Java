package bit_courseJAVA.basic.Extends;

public class Animals {
    public String name;
    public int age=2;

    public void eat()
    {
        System.out.println("eat");
    }

    public Animals(String name)  //父类如果有构造方法需要在子类调用父类的构造方法
    {
        this.name=name;
    }
}
