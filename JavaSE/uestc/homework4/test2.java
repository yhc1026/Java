package uestc.homework4;

public class test2 {
    public static void main(String[] args) {
        checker c1=new checker();
        try{
            c1.check('a');
            c1.check('b');
            c1.check('c');
            c1.check('1');
        }catch(NotCharacterException e)
        {
            System.out.println(e.getMessage());
        }
    }
}