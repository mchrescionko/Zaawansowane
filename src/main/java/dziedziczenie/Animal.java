package dziedziczenie;

public abstract class Animal implements Comparable<Animal>{

    protected int age;
    protected String name;


    public Animal() {
        age = 10;
        name = "Gringo";
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo( Animal o) {
        return age-o.age;
    }

    public abstract void sound();

    public void feed(){
        System.out.print("Karmię zwierze");
    }

}
