package refleksja2;

public class Dog {
    public String name;
    public Dog dog;
    public String [] imiona;
    public Integer [] nogi;
    public Dog dog2;

    public Dog(String name, Dog dog, String[] imiona, Integer[] nogi, Dog dog2) {
        this.name = name;
        this.dog = dog;
        this.imiona = imiona;
        this.nogi = nogi;
        this.dog2 = dog2;
    }

    public String getName() {
        return name;
    }

    public Dog getDog() {
        return dog;
    }

    public String[] getImiona() {
        return imiona;
    }

    public Integer[] getNogi() {
        return nogi;
    }

    public Dog getDog2() {
        return dog2;
    }
}
