package uestc.book;

import java.util.*;



public class Book {
    private String name;
    private Author[] Authors;
    private double price;
    private int qty=0;

    public Book(String name, Author[] Authors, double price)
    {
        this.name=name;
        this.Authors=Authors;
        this.price=price;
    }

    public Book(String name, Author[] Authors, double price, int qty)
    {
        this.name=name;
        this.Authors=Authors;
        this.price=price;
        this.qty=qty;
    }

    public String getName()
    {
        return this.name;
    }

    public Author[] getAuthors() {
        return Authors;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price=price;
    }

    public int getQty()
    {
        return this.qty;
    }

    public void setQty(int qty)
    {
        this.qty=qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", Authors=" + Arrays.toString(Authors) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public String getAuthorsNames()
    {
        String names="";
        for (int i = 0; i < Authors.length; i++)
        {
            String name=Authors[i].getName();
            names=names+","+name;
        }
        return names;
    }
}
