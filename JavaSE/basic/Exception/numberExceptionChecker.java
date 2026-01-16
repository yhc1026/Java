package bit_courseJAVA.basic.Exception;

import java.util.Scanner;

public class numberExceptionChecker {
    public int number;
    public numberExceptionChecker()
    {
        System.out.println("输入一个数字");
        Scanner s=new Scanner(System.in);
        this.number=s.nextInt();
    }
    public void checker() throws numberException{
        if(this.number!=0)
        {
            numberException e=new numberException("错误数字");
            throw e;
        }
    }
}
