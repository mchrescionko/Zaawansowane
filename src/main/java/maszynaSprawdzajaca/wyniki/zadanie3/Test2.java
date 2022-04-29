package maszynaSprawdzajaca.wyniki.zadanie3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("DaneWejsciowe"));
        Scanner scanner = new Scanner(System.in);
        int x=0;
//        System.out.println("xintest: "+x);
        int answer = 0;
        while(scanner.hasNextLine()){
            x = scanner.nextInt();
            answer=answer+x;
        }
        answer=answer+2;
        System.out.println(answer);

    }
}