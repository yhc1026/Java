package bit_courseJAVA.basic.Thread;

public class test_MyThread {
    public static void main(String[] args) {
        Thread t = new MyThread();
        //t.run();                              如果使用run方法，run方法所在的内容会占据main线程，cpu执行main线程中的程序，也就执行了run方法所在的程序
        t.start();         //真正在系统中创建出一个线程
        while(true)
        {
            System.out.println("hello, main");        //main线程和Thread线程同时占用cpu，执行哪个为随机事件
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
