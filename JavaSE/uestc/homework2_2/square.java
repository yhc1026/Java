package uestc.homework2_2;

public class square extends rectangle{
    double side;

    public square(){};
    public square(double side)
    {
        this.side=side;
    }

    public square(double side, String color, boolean filled)
    {
        super(side, side, color, filled);//调用上一层父类的构造方法

    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setWidth(double side)
    {
        super.width=side;
    }

    public void setLength(double side)
    {
        super.length=side;
    }

    public String toString() {
        return "Square[side=" + side + ", color=" + super.getColor() + ", filled=" + super.isFilled() + "]";
    }
}
