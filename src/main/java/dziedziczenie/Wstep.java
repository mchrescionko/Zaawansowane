package dziedziczenie;

import java.io.CharArrayReader;
import java.util.ArrayList;

public class Wstep {
    public static void main(String[] args) {

        Dog dog = new Dog(3);
        Cat cat = new Cat(3, "Kropka");
        System.out.println(dog);

        dog.aportowanie();
        dog.sound();

        cat.drapanie();
        cat.sound();

        dog.feed();
        cat.feed();

        CareTaker careTaker = new CareTaker();
        careTaker.feedAnimal(dog);
        careTaker.feedAnimal(cat);

        System.out.println("nowe");

        Animal animal = cat;
        animal.feed();
        animal = dog;
        animal.feed();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);

        for (Animal animal1 : animals) {
            animal1.feed();
        }

        Dog dog3 = new Dog(4);
        dog3.pet();



OuterClass outerClass = new OuterClass();



//        Animal animal = new Animal();

    }
}
