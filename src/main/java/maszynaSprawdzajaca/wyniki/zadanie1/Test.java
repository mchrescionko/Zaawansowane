package maszynaSprawdzajaca.wyniki.zadanie1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {

        task();

    }

    private static void task() throws FileNotFoundException {
        System.setIn(new FileInputStream("DaneWejsciowe"));
        Scanner scanner = new Scanner(System.in);
        int x=0;
//        System.out.println("xintest: "+x);
        int answer = 0;
        while(scanner.hasNextLine()){
            x = scanner.nextInt();
            answer=answer+x;
        }

        System.out.println(answer);
    }
}