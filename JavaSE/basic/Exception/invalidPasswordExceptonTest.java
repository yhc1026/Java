package bit_courseJAVA.basic.Exception;

public class invalidPasswordExceptonTest {
    public static void main(String[] args) {
        invalidPasswordExceptionChecker ic=new invalidPasswordExceptionChecker();
        ic.setPassword(99999);
        try {
            ic.checker();
        }catch (invalidPasswordException e)
        {
            System.out.println("已经捕获");
            System.out.println("原因是"+e.getMessage());
        }
    }
}
