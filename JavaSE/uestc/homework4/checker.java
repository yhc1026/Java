package uestc.homework4;

public class checker {
    public int cnt;

    public checker()
    {
        this.cnt=0;
    }
    public void check(char a) throws NotCharacterException
    {
        if((a>=65&&a<=90)||(a>=97&&a<=122))
        {
            cnt++;
            System.out.println("第"+cnt+"个字符是"+a);
        }
        else
        {
            cnt++;
            NotCharacterException e= new NotCharacterException("第"+cnt+"不是字符");
            throw e;
        }
    }

}