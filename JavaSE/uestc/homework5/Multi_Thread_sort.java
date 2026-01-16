package uestc.homework5;

public class Multi_Thread_sort extends Thread {
    public void CreateThread(int[] array) {
        for (int i = 0; i < array.length; i++) {
            NewThread t = new NewThread(array[i]);
            t.start();
        }
    }
}

