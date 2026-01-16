package bit_courseJAVA.basic.Extends;

public class Dog extends Animals{
    public int age=1;
    public void bark()
    {
        System.out.println("wangwangwang");
    }

    public void age()               //super关键字：当子类和父类出现同名成员变量，优先访问子类，如需访问父类，就需要加super关键字
    {
        System.out.println(age);
        System.out.println(super.age);
    }

    public Dog(){
        super("dog1");
    }

}
