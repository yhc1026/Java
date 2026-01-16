package bit_courseJAVA.basic.Interface;

public class main {
    public static void test(Iinterface i)
    {
        i.test1();
    }

    public static void main(String[] args) {
        Iinterface i1=new test1();
        test(i1);

        Iinterface i2=new test2();
        test(i2);
    }
}
