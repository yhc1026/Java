package uestc.triangle;

public class test_triangle_type {
    public static void main(String[] args) {
        triangle_type tp1=new triangle_type(20,30,30);
        System.out.println("20,30,30构成"+tp1.type()+"三角形");

        triangle_type tp2=new triangle_type(45,45,45);
        System.out.println("45,45,45构成"+tp2.type()+"三角形");

        triangle_type tp3=new triangle_type(48,71,42);
        System.out.println("48,71,42构成"+tp3.type()+"三角形");

        triangle_type tp4=new triangle_type(80,30,10);
        System.out.println("80,30,10构成"+tp4.type()+"三角形");
    }
}
