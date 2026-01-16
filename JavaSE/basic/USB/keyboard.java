package bit_courseJAVA.basic.USB;

public class keyboard implements IUSB
{
    public void turnOn()
    {
        System.out.println("开键盘");
    }
    public void turnDown()
    {
        System.out.println("关健盘");
    }

    public void function()
    {
        System.out.println("input");
    }
}
