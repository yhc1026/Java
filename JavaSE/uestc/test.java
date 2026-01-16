package uestc;

abstract class Figure {
    double dim1;
    double dim2;
    static int count=0;
    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
        count++;
    }
    abstract double area();
}

interface Color{
    String []color= {"RED","BLUE","GREEN"};
    String getColor(int color);
}

class Rectangle extends Figure implements Color{
    int color;
    Rectangle(double a, double b,int color) {
        super(a, b);
        this.color = color;
    }
    double area() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
    }
    public String getColor(int color) {
        return Color.color[color];
    }
    public String toString() {
        return "Count:"+count+" Color:"+getColor(color)+" Area:"+area();
    }
}

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }
    double area() {
        System.out.println("Inside Area for Triangle.");
        return dim1 * dim2 / 2;
    }
}

class AbstractAreas {
    public static void main(String args[]) {
        Rectangle r = new Rectangle(9, 5,1);
        Triangle t = new Triangle(10, 8);
        Figure figref;
        figref = r;
        System.out.println(figref);
        figref = t;
        System.out.println(figref.area());}
}
