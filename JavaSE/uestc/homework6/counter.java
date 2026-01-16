package uestc.homework6;

import java.io.*;

public class counter {
    public int count(String filepath)
    {
        int cnt=0;
        int t=0;
        try {
            FileInputStream fis=new FileInputStream(filepath+"/testsource.txt");
            File testdestination=new File(filepath+"/testdestination.txt");
            FileOutputStream fos=new FileOutputStream(filepath+"/testdestination.txt");
            testdestination.createNewFile();
            while(t!=-1)
            {
                t=fis.read();
                fos.write((char)t);
                cnt++;
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("文件未找到: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO错误: " + e.getMessage());
        }
        return cnt;
    }
}
