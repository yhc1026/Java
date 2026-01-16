package uestc.shape;

public class rectangle {
    private float length=1.0f;
    private float width=1.0f;

    public rectangle()
    {

    }

    public rectangle(float length, float width)
    {

    }

    public float getLength()
    {
        return length;
    }

    public void setLength(float length)
    {
        this.length=length;
    }

    public float getWidth()
    {
        return width;
    }

    public void setWidth(float width)
    {
        this.width=width;
    }

    public double getArea()
    {
        return this.width*this.length;
    }

    public double getPerimeter()
    {
        return this.width*2+this.length*2;
    }

    public String toString()
    {
        return "Rectangle[length="+this.length+"cm, width="+this.width+"cm]";
    }
}
