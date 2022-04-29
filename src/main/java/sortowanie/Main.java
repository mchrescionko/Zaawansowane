package sortowanie;

import dziedziczenie.Animal;
import dziedziczenie.Dog;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(2);


//        System.out.println(list);;
//
//        Dog dog = new Dog(10);
////        Dog.InnerClass innerClass = dog.new InnerClass();
//        Dog.InnerClass innerClass = new Dog.InnerClass();
        class LocalClass implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }

        LocalClass localClass = new LocalClass();
        list.sort(localClass);
        System.out.println(list);

        Dog dog = new Dog(10){
            @Override
            public void sound() {
                System.out.println("nowe hau hau");;
            }
        };

        Dog dog1 = new Dog(11);
        System.out.println(localClass.getClass().getName());
        System.out.println(dog.getClass().getName());
        System.out.println(dog1.getClass().getName());
        System.out.println(dog1.getClass());

        dog.sound();
        list.sort(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        System.out.println(list);
        Set<Animal> animalList = new TreeSet<>();
        animalList.add(new Dog(11));
        animalList.add(new Dog(312));
        animalList.add(new Dog(163));


        System.out.println(animalList);

        }



    }
    class KlasaWewnetrzna{

    }

class Klasa{

}
