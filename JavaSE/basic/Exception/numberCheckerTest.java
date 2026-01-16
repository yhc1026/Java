package bit_courseJAVA.basic.Exception;

public class numberCheckerTest {
    public static void main(String[] args) {
        numberExceptionChecker nt=new numberExceptionChecker();
        try{
            nt.checker();
            System.out.println("恭喜输入正确");
        }catch(numberException e){
            System.out.println(e.getMessage());
        }
    }
}
