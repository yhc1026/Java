package uestc.homework5;

public class NewThread extends Thread{
    private int time;

    public NewThread(int time) {
        this.time = time;
    }


    public void run() {
        sort();
    }

    public void sort()
    {
        try {
            Thread.sleep(time);  // 睡眠时间与元素值成正比
            System.out.println(time);  // 输出元素
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
