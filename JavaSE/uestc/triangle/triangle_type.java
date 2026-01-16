package uestc.triangle;

public class triangle_type {
    private int a;
    private int b;
    private int c;

    public triangle_type(int a, int b, int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public String type()
    {
        if(a+b<=c||a+c<=b ||b+c<=a)
        {
            return "不是";
        }
        if (a == b && b == c) {
            return "等边";
        }
        if (a == b || a == c || b == c) {
            return "等腰";
        }
        return "不规则的";
    }
}
