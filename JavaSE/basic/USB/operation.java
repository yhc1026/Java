package bit_courseJAVA.basic.USB;

public class operation {
    public static void main(String[] args) {
        computer cpt1=new computer();
        IUSB M=new mouse();
        IUSB K=new keyboard();
        cpt1.useComputer(M, K);
    }
}
