package pracaZPlikami;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        File plik = new File("PierwszyPlik");
//        Scanner scanner = new Scanner(plik);
//        String text = scanner.nextLine();
//        System.out.println(text);
//
//        while(scanner.hasNextLine()){
//            text = scanner.nextLine();
//            System.out.println(text);
//        }
//
//        PrintWriter zapis = new PrintWriter("DrugiPlik");
//        zapis.println("Pierwszy zapisany wiersz");
//        zapis.close();
//
//        File plik2 = new File("DrugiPlik");
//        Scanner scanner1 = new Scanner(plik2);
//        String text2 = scanner1.nextLine();
//        System.out.println(text2);
//
        String pathPierwszyFolder = "C:\\Users\\maciek\\IdeaProjects\\Zaawansowane\\Folder1";


        ZamianaPlikow zamianaPlikow = new ZamianaPlikow(pathPierwszyFolder);
        zamianaPlikow.zamien();

    }

}
