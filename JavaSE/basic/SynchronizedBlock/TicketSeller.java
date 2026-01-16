package bit_courseJAVA.basic.SynchronizedBlock;

public class TicketSeller implements Runnable{
    private int ticket=100;
    public String name;

    Object object=new Object();
    Exception e=new Exception();

    public void run() {
        while (true) {
            synchronized (e) { // 使用 lock 对象作为锁
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票，还剩" + ticket + "张票");
                    ticket--;
                } else {
                    break; // 票卖完后退出循环
                }
            }
            try {
                Thread.sleep(100); // 模拟售票时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
