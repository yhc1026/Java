package bit_courseJAVA.basic.Extends;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.eat();
        cat1.mimi();

        Dog dog1=new Dog();
        dog1.name="Alaska";
        dog1.eat();
        System.out.println(dog1.name);
        dog1.bark();

        dog1.age();
    }
}
