package algorytm;

public class Main2 {
    public static void main(String[] args) {

        Int1 int1 = ()->new Int1() {
            @Override
            public void print() {

            }
        };



    }
}

interface Int1 {
    public void print();

}

abstract class Abs{
    public void printABS(){
        System.out.println("ff");
    }
}
