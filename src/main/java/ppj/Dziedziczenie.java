package ppj;

public class Dziedziczenie {
     int numer;

    public Dziedziczenie(int numer) {
        this.numer = numer;
    }

    public static void main(String[] args) {
        Dziedziczenie dziedziczenie = new Dziedziczenie(1);
        numer2 numer2 = new numer2(1);
        System.out.println(dziedziczenie.numer);
        System.out.println(numer2.numer);


    }


}

class numer2 extends Dziedziczenie{
     int numer;

    public numer2(int numer) {
        super(numer);
    }

    @Override
    public String toString() {
        return "numer2{" +
                "numer=" + numer +
                '}';
    }
}
