package bit_courseJAVA.basic.USB;

public class mouse implements IUSB{
    public void turnOn()
    {
        System.out.println("开鼠标");
    }
    public void turnDown()
    {
        System.out.println("关鼠标");
    }

    public void function()
    {
        System.out.println("click");
    }
}
