package bit_courseJAVA.basic;

class date
{
    int Year;
    int Month;
    int Day;

    public void setdate(int y, int m, int d)              //也可以使用this关键词初始化,建议无论如何加上this
    {
        this.Year=y;
        this.Month=m;
        this.Day=d;
    }

    public date(int year) {
        this(2024, 8, 8);                //构造方法内调用其他构造方法
        Year = year;
    }

    public date(int year, int month, int day) {

        Year = year;
        Month = month;
        Day = day;
    }

    public void printdate()
    {
        System.out.println(this.Year+"."+this.Month+"."+this.Day);
    }

    public date()//构造方法，实例化会执行构造方法；也可以ALT+INSERT组合键快速生成构造方法
    {
        System.out.println("构造方法测试");
        this.Year=2024;
    }
}

public class Class2 {
    public static void main(String[] args) {
        date day1=new date();
        date day2=new date();
        date day3=new date();
        date dayz=new date();

        day1.setdate(2008,8,8);
        day2.setdate(2009,9,9);
        day3.setdate(2010,10,10);

        System.out.println(day1.Year+"."+day1.Month+"."+day1.Day);
        System.out.println(day2.Year+"."+day2.Month+"."+day2.Day);
        System.out.println(day3.Year+"."+day3.Month+"."+day3.Day);
        System.out.println(dayz.Year+"."+dayz.Month+"."+dayz.Day);
    }
}
