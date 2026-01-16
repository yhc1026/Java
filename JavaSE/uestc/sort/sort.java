package uestc.sort;

public class sort {
    public static void sort1(int[] arr)
    {
       int i=0, j=1;
       for(i=0;i<j;i++)
       {
           j=i+1;
           for(;j<arr.length;j++)
           {
               if(arr[i]>arr[j])
               {
                   int t=arr[i];
                   arr[i]=arr[j];
                   arr[j]=t;
               }
           }
       }

    }

    public static void main(String[] args) {
        int[]arr1={4,5,6,7,2,8,9,3,1};
        sort1(arr1);
        int t=0;
        while(t<arr1.length)
        {
            System.out.println(arr1[t]);
            t++;
        }
    }
}
