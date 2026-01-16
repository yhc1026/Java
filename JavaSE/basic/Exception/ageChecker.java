package bit_courseJAVA.basic.Exception;

public class ageChecker {
    public int age;
    public ageChecker(int age)
    {
        this.age=age;
    }
    public void checker() throws E1 {
        if(this.age<0)
        {
            E1 e=new E1("年龄不正确");
            throw e;
        }
    }
}
