package bit_courseJAVA.basic;
//访问修饰限定符号：private（封装）修饰

class time
{
    private int hour;
    private int minute;
    private int second;
    private String Calender;

    public int getMinute() {        //也可以通过ALT+INSERT快捷键快速get和set
        return minute;
    }

    public time(int hour, int minute, int second, String calender) {  //构造方法也可以访问封装成员
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        Calender = calender;
    }

    public void setTime(int H, int M, int S, String C)
    {
        this.hour=H;
        this.minute=M;
        this.second=S;
        this.Calender=C;
    }

    public void printTime()
    {
        System.out.println("it is "+this.hour+":"+this.minute+":"+this.second+", "+this.Calender);
    }

    private void printer()               //方法也可以封装
    {
        System.out.println("已被调用");
    }

    public void avtivator()              //需要用public方法调用
    {
        this.printer();
    }
}

public class Class3 {
    public static void main(String[] args) {
        time time1=new time(21,52,36,"PM");
        time1.printTime();
        //time1.hour=10;  此处报错，因为private已经将类封装，类外无法获取类成员
        time1.setTime(10,24,13,"AM");

        //time1.printTime();  此处报错，因为private已经将类封装，类外无法调用类方法
        time1.printTime();
        time1.avtivator();
    }

}
