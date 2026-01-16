package bit_courseJAVA.basic;

public class Exception1 extends Throwable {
    public static void main1(String[] args) {
        System.out.println(10/0);           //arithmetic exception：算数异常
    }

    public static void main2(String[] args) {
        int[] arr1={1,2,3,4,5};
        System.out.println(arr1[10]);       //ArrayIndexOutOfBoundsException：数组越界异常
    }

    public static void main3(String[] args) {
        int[] arr=null;
        System.out.println(arr.length);//空指针异常
    }


    //所有异常都可以被Exception捕获，因为所有异常类型都是Exception的子类
    public static void main(String[] args) {           //try-catch语句，检测try中程序是否存在异常
        System.out.println("第一行代码");

        try {
            System.out.println(10/0);
        }  catch (ArithmeticException e){                 //如果这里的错误类型不匹配，仍然会在编译时报错
            System.out.println("除数为0");
        } catch(NullPointerException e){
            System.out.println("空指针");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
        }catch (Exception e){
            System.out.println("异常");
        }


        System.out.println("第二行代码");
    }

}