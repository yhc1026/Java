package bit_courseJAVA.basic.SynchronizedMethod;

public class TIcketSeller implements Runnable{
    public int ticket=100;
    public void run()
    {
        while(true)
        {
            ticketSeller();
        }
    }

    public synchronized void ticketSeller()
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(this.ticket>=0)
        {
            ticket--;
            System.out.println("还剩"+this.ticket+"张票");
        }
    }
}