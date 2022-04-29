package dziedziczenie;

public class Dog extends Animal implements HouseAnimal{


    public Dog(int age) {
        super(age, "bblaa");
    }



    @Override
    public void sound() {
        System.out.println("Hau");
    }

    public void aportowanie(){
        System.out.println("Pies "+name+" biegnie za kością");
    }

    @Override
    public void feed() {
        super.feed();
        System.out.println(" karmą");
    }

    @Override
    public String toString(){
        return "Pies "+name+", wiek: "+age;
    }

    @Override
    public void pet() {
        System.out.println("PETPET");
    }

    public static class InnerClass{
        public InnerClass() {
            System.out.println("nowy obiekt");
        }
    }
}

class OuterClass{
    public OuterClass() {
    }
}