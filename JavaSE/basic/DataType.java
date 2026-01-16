//JAVA里有整形，长短整形，字节型（byte）,单双精度浮点（float/double），字符型（char），布尔型（boolean）

package bit_courseJAVA.basic;

public class DataType {
    public static void main(String[] args) {

        final int a = 10;//final相当于const
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);//得出int型的最大最小值
        System.out.println(Integer.MIN_VALUE);

        byte b=10;
        System.out.println(b);
        System.out.println(Byte.MAX_VALUE);//127
        System.out.println(Byte.MIN_VALUE);//-128

        char c='杨';
        System.out.println(c);//由于char型是两个字节，所以可以存储汉字

        byte m=10;
        System.out.print(m);
        int n=128;
        //m=n; 此处会报错，因为小字节无法转向大字节
        m=(byte)n;//此处不会报错，但可能存在精度丢失
        //byte t=m+n报错，以为c无法承受int类型
        int t=(int)(m+n);//将m强制转换为int，再相加
        //寄存器读写最小单位是四个字节，所以对于小于四个字节的运算，都会提升为四个字节来进行运算
        
        System.out.println(t);

        String arr1="hello,";
        String arr2="world";
        String arr=arr1+arr2;
        System.out.println(arr);//字符串相加等于拼接，输出hello，world
        System.out.println("a="+a);//利用字符串加法输出”a=10“
        System.out.printf("%d",a);//c语言语法沿用至JAVA

    }
}
