package dziedziczenie;

public class Cat extends Animal{

    private int age;
    private String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }



    public void drapanie(){
        System.out.println("Kot "+name+" drapie");
    }

    @Override
    public void feed() {
        super.feed();
        System.out.println(" rybą");
    }

    @Override
    public void sound() {
        System.out.println("Miau");
    }
}
