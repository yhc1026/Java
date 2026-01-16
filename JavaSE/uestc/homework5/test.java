package uestc.homework5;

public class test {
    public static void main(String[] args) {
        int[] array = {3,5,6,2,1,0,8};
        Multi_Thread_sort m = new Multi_Thread_sort();
        m.CreateThread(array);
    }
}
