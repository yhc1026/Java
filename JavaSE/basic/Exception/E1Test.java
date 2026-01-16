package bit_courseJAVA.basic.Exception;

public class E1Test {
    public static void main(String[] args) {
        ageChecker ac=new ageChecker(-1);
        try{
            ac.checker();
        }catch (E1 e) {
            System.out.println("已经捕获异常");
        }
    }
}
