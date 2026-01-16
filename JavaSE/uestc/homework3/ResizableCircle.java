package uestc.homework3;

public class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius)
    {
        super(radius);
        this.radius=radius;
    }

    public void resize(int persent)
    {
        super.radius=super.radius*persent;
    }
}
