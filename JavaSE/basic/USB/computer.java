package bit_courseJAVA.basic.USB;

public class computer{
    public static void powerOn(IUSB usb)
    {
        usb.turnOn();
    }

    public static void powerOff(IUSB usb)
    {
        usb.turnDown();
    }

    public static void function(IUSB usb)
    {
        usb.function();
    }

    public static void useComputer(IUSB m, IUSB k)
    {
        powerOn(m);
        powerOn(k);
        function(m);
        function(k);
        powerOff(m);
        powerOff(k);
    }
}
