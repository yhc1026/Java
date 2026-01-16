package uestc.book;

import java.util.Arrays;
import java.util.List;

public class test_book {
    public static void main(String[] args) {
        Author author1=new Author("Jack", "1234@abc.com", 'M');
        Author author2=new Author("Mark", "5678@abc.com", 'M');
        Author author3=new Author("Jane", "0000@abc.com", 'F');

        Author[] Authors={author1, author2,author3};

        Book book1=new Book("JAVA",Authors , 50.0, 100 );

        System.out.println("informations of the authors: "+book1.getAuthors());
        System.out.println("this book is written by "+book1.getAuthorsNames());
        System.out.println("this book is called "+book1.getName());
        System.out.println("there are "+book1.getQty()+" books");
        System.out.println("this book sells "+book1.getPrice()+" dollars");

        System.out.println(book1);
    }
}
