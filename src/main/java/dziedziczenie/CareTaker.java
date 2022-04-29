package dziedziczenie;

public class CareTaker {

    public void feedAnimal(Animal animal){
        System.out.println("Karmię zwierzę");
        animal.feed();
        System.out.println("nakarmiony");
        animal.sound();
    }

}
