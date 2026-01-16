package bit_courseJAVA.basic;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
    int[]arr={1,3,9,2,5,0,7,6,3,5};
    sort2(arr);
    }
    public static void sort1(int[] arr)               //奇偶分离
    {
        Arrays.sort(arr);//奇偶分离
        int i=0, j=arr.length-1;
        while(i<j)
        {
            if(arr[i]%2==0&&arr[j]%2!=0)
            {
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                j--;
                i++;
            }
            else if(arr[i]%2==0&&arr[j]%2==0)
            {
                j--;
            }
            else if(arr[i]%2!=0&&arr[j]%2!=0)
            {
                i++;
            }
            else
            {
                i++;j--;
            }
        }

        String res= Arrays.toString(arr);
        System.out.println(res);
    }
    public static void sort2(int[] arr) {              //查看数组中是否存在三个连续的奇数
        int cnt = 0, t = 0;
        while (t < arr.length - 1) {
            if (cnt == 3) {
                System.out.println("true");
                return;
            }
            if (arr[t] % 2 != 0)
            {
                cnt++;
                t++;
            }
            else
            {
                cnt = 0;
                t++;
            }
        }
        System.out.println("false");
        return;
    }
}
