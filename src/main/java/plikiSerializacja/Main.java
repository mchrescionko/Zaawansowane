package plikiSerializacja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("nazwa pliku.csv");
        printWriter.println("pierwsza kolumna,druga kolumna");
        printWriter.println("druga linia pierwsza kolumna");
        printWriter.close();

        File file = new File("nazwa pliku.csv");
        Scanner scanner = new  Scanner(file);
        while(scanner.hasNextLine()){
            String pierwszaLinia = scanner.nextLine();
            List<String> stringList = Arrays.asList(pierwszaLinia.split(","));
            for (String s : stringList) {
                System.out.println(s);
            }
        }

    }
}
