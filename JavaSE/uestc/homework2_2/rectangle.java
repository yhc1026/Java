package uestc.homework2_2;

public class rectangle extends Shape{
    double width;
    double length;

    public rectangle(){}

    public rectangle(double width, double length)
    {
        this.length=length;
        this.width=width;
    }

    public rectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        this.length=length;
        this.width=width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea()
    {
        return this.length*this.width;
    }

    public double getPerimeter()
    {
        return this.length*2+this.width*2;
    }

    public String toString() {
        return "Rectangle[" + "width=" + width + ", length=" + length + ", color='" + getColor() + ' ' + ", filled=" + isFilled() + ']';
    }
}
