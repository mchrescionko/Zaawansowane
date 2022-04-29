package pracaZPlikami.wyjatki;

import java.util.InputMismatchException;

public class WyjatkiDemo {
    public static void main(String[] args) {
        try {
            rzucWyjatek();
            System.out.println("to sie nie wydarzy");
        }catch(InputMismatchException e){
            System.out.println("wystapil blad");
        }
        System.out.println("ciag dalszy");
    }

    public static void rzucWyjatek(){
        throw new InputMismatchException();
    }
}
