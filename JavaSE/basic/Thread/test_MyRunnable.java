package bit_courseJAVA.basic.Thread;

public class test_MyRunnable {
    public static void main(String[] args) {
        Runnable m=new MyRunnable();
        //m.run();                                如果使用run方法，run方法所在的内容会占据main线程，cpu执行main线程中的程序，也就执行了run方法所在的程序
        Thread t=new Thread(m);                 //创建一个新的 Thread 对象，并将 Runnable 对象传递给它。当启动这个线程时，线程会执行 Runnable 对象的 run 方法。
        t.start();
        while(true)
        {
            System.out.println("hello, java");
            try{Thread.sleep(1000);}
            catch(InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

/*
Runnable m = new MyRunnable();
m.run();
和
Runnable m = new MyRunnable();
Thread t= new Thread(m);
t.run();
没有本质区别，都是在当前线程启动run方法所在的程序
*/