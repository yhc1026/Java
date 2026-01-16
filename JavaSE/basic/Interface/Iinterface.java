package bit_courseJAVA.basic.Interface;

//接口
//接口当中的成员变量默认是public static final
//接口中的方法默认为抽象方法
//如果接口方法被default或者static修饰，则可以有具体实现
//不可被实例化
//类和接口之间可以使用implement调用，但是必须实现接口中的抽象方法
//和类不同，接口可以多继承

public interface Iinterface {
    public static final int a=0;

    public abstract void test1();

    public static void test2()
    {
        System.out.println("已调用");
    }

    default void test3()
    {
        System.out.println("已调用");
    }
}
