package uestc.shape;

public class test_shape {
    public static void main(String[] args) {
        circle circle1=new circle();
        System.out.println("Area of circle1="+circle1.getArea());
        System.out.println("Radius of circle1="+circle1.getRadius());
        rectangle rectangle1=new rectangle();
        System.out.println("area of rectangle1="+rectangle1.getArea());
        System.out.println("perimeter of rectangle1="+rectangle1.getPerimeter());
    }
}
