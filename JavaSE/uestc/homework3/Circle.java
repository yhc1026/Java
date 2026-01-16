package uestc.homework3;

public class Circle implements GeometricObject{
    double radius=1.0;

    public Circle(double radius)
    {
        this.radius=radius;
    }
    public double getPerimeter()
    {
        return Math.PI*radius*2;
    }
    public double getArea()
    {
        return Math.PI*radius*radius;
    }
}
