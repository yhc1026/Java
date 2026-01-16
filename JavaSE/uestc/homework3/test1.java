package uestc.homework3;

public class test1 {
    public static void main(String[] args) {
        ResizableCircle RC1=new ResizableCircle(2.0);

        System.out.println(RC1.radius);
        System.out.println(RC1.getArea());
        System.out.println(RC1.getPerimeter());

        RC1.resize(2);
        System.out.println("after resize");

        System.out.println(RC1.radius);
        System.out.println(RC1.getArea());
        System.out.println(RC1.getPerimeter());
    }
}