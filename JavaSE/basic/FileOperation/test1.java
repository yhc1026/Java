package bit_courseJAVA.basic.FileOperation;

import java.io.File;
import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        File file1=new File("D:/codeC/java-int/JDK18/bit_courseJAVA/FileOperation/text.txt");
        System.out.println(file1.getParent());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.exists());

        //boolean flag=file.delete();
        //System.out.println("if delete: "+flag);

        File List=new File("./");
        String[] arr=List.list();
        System.out.println(Arrays.toString(arr));

        File C=new File("C:/");
        String[] arr2=C.list();
        System.out.println(Arrays.toString(arr2));

        File[] f=C.listFiles();
        System.out.println(Arrays.toString(f));

        File file2=new File("./test1");
        boolean flag=file2.mkdir();
        System.out.println(flag);

        File file3=new File("./test/111/222/333");
        boolean flag2=file3.mkdirs();
        System.out.println(flag2);
    }
}