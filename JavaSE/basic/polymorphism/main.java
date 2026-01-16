package bit_courseJAVA.basic.polymorphism;

public class main {
    public static void main(String[] args) {
        /*dog dog1=new dog();            向上转型
        Animal huski=dog1;*/
        Animal huski=new dog();

        huski.bark();
        //huski.eat();
    }
}
