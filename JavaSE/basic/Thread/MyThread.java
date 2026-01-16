package bit_courseJAVA.basic.Thread;
//多线程程序方法1：创建类继承Thread，重写run方法
public class MyThread extends Thread{
    public void run()                    //run相当于线程的入口，重写run方法，为run方法赋予特定的功能
    {
        while(true)
        {
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);     //主动放弃cpu占用，sleep是一个静态方法，只需要用类名调用，参数是毫秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}