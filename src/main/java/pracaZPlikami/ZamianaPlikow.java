package pracaZPlikami;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZamianaPlikow {

    private String PierwszyFolder;


    public ZamianaPlikow(String pierwszyFolder) {
        PierwszyFolder = pierwszyFolder;

    }

    public void zamien() throws FileNotFoundException {

        File file = new File(PierwszyFolder);
        File [] tablica = file.listFiles();

        for (File file1 : tablica) {
            if(file1.isDirectory()){
//                String nazwaFolderu = file1.getName();
//                File file3 = new File(drugiFolder+'/'+nazwaFolderu);  //C:/sciezka/nazwaTwojegoFolderu
//                file3.mkdir();
                ZamianaPlikow zamianaPlikow = new ZamianaPlikow(file1.getAbsolutePath());
                zamianaPlikow.zamien();
            }
            String nazwa = file1.getName();
//            String nazwaSciezka = drugiFolder+"/"+nazwa;
//            PrintWriter printWriter = new PrintWriter(nazwaSciezka);
            System.out.println(nazwa);

            if(!file1.isDirectory()){
                Scanner scanner = new Scanner(file1);
                while(scanner.hasNextLine()){
                    String text = scanner.nextLine();
                    System.out.println(text);;
                }
            }

//            printWriter.close();
        }



//        PrintWriter printWriter = new PrintWriter(PierwszyFolder);
//        printWriter.println(file.listFiles(PierwszyFolder););

    }
}
