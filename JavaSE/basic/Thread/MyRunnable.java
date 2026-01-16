package bit_courseJAVA.basic.Thread;
//多线程程序方法2：创建类实现Runnable接口，重写run方法，这样可以解耦合
public class MyRunnable implements Runnable{
    public void run()
    {
        while(true)
        {
            System.out.println("hello,world");
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException e)
                 {
                     throw new RuntimeException(e);
                 }
        }
    }
}
