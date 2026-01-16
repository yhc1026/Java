package bit_courseJAVA.basic.FileOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test2 {
    public static String path="D:/codeC/java-int/JDK18/bit_courseJAVA/FIleOperation/text.txt";
    public static void main(String[] args) throws FileNotFoundException {
        try(InputStream inputstream1= new FileInputStream(path)) {
            int letter=0;
            while(letter!=-1)
            {
                letter=inputstream1.read();    //read方法一次读入一个字符，返回int型数据，数据范围在0-255
                System.out.print((char) letter);
            }
            inputstream1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");

        //利用数组，使一次inputstream读入多个字节
        byte[] data=new byte[1024];            //创建一个1024字节的数组对象
        int n=0;
        try (InputStream inputStream2=new FileInputStream(path)){
            n=inputStream2.read(data);           //此时尽可能多的读入字节，直到1024字节的数组被填满;读完后返回一个int变量，表示实际读到的字节数
            System.out.println("共读入"+n+"次");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<n;i++)
        {
            System.out.print((char)data[i]);
        }
    }
}
